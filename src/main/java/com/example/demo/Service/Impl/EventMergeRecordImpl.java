EventMergeServiceImpl.java

package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository repo;

    public EventMergeServiceImpl(EventMergeRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        EventMergeRecord record = new EventMergeRecord();
        record.setSourceEventIds(eventIds.toString());
        record.setMergeReason(reason);
        record.setCreatedAt(LocalDateTime.now());
        return repo.save(record);
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return repo.findAll();
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return repo.findByCreatedAtBetween(start.atStartOfDay(), end.atTime(23,59));
    }
}