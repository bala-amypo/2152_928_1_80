package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EventMergeServiceImpl {

    private final AcademicEventRepository eventRepository;
    private final EventMergeRecordRepository mergeRepository;

    public EventMergeServiceImpl(AcademicEventRepository eventRepository,
                                 EventMergeRecordRepository mergeRepository) {
        this.eventRepository = eventRepository;
        this.mergeRepository = mergeRepository;
    }

    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        List<AcademicEvent> events = eventRepository.findAllById(eventIds);

        if (events == null || events.isEmpty()) {
            throw new ResourceNotFoundException("No events found");
        }

        EventMergeRecord record = new EventMergeRecord();

        record.setSourceEventIds(
                events.stream()
                        .map(e -> e.getId().toString())
                        .collect(Collectors.joining(","))
        );

        record.setMergedTitle("Merged Events");

        LocalDate minStart = events.stream()
                .map(AcademicEvent::getStartDate)
                .min(LocalDate::compareTo)
                .orElse(null);

        LocalDate maxEnd = events.stream()
                .map(AcademicEvent::getEndDate)
                .max(LocalDate::compareTo)
                .orElse(null);

        record.setMergedStartDate(minStart);
        record.setMergedEndDate(maxEnd);
        record.setMergeReason(reason);

        record.prePersist();
        return mergeRepository.save(record);
    }

    public List<EventMergeRecord> getMergeRecordsByDate(
            LocalDate start, LocalDate end) {
        return mergeRepository.findByMergedStartDateBetween(start, end);
    }
}
