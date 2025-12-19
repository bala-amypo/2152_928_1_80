package com.example.demo.serviceimpl;

import com.example.demo.entity.EventMergeRecordEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository repository;

    public EventMergeServiceImpl(EventMergeRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventMergeRecordEntity mergeEvents(List<Long> eventIds, String reason) {
        EventMergeRecordEntity record = new EventMergeRecordEntity();
        record.setSourceEventIds(
                eventIds.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")));
        record.setMergeReason(reason);
        record.setMergedTitle("Merged Event");

        return repository.save(record);
    }

    @Override
    public List<EventMergeRecordEntity> getAllMergeRecords() {
        return repository.findAll();
    }

    @Override
    public EventMergeRecordEntity getMergeRecordById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Merge record not found"));
    }

    @Override
    public List<EventMergeRecordEntity> getMergeRecordsByDate(
            LocalDate start, LocalDate end) {

        return repository.findAll().stream()
                .filter(r ->
                        !r.getCreatedAt().toLocalDate().isBefore(start)
                     && !r.getCreatedAt().toLocalDate().isAfter(end))
                .collect(Collectors.toList());
    }
}
