package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;

import java.util.List;

public class ClashDetectionServiceImpl {

    private final ClashRecordRepository repository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    public List<ClashRecord> getClashesForEvent(Long eventId) {
        return repository.findByEventAIdOrEventBId(eventId, eventId);
    }

    public List<ClashRecord> getUnresolvedClashes() {
        return repository.findByResolvedFalse();
    }

    public ClashRecord resolveClash(Long clashId) {
        ClashRecord record = repository.findById(clashId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Clash not found"));

        record.setResolved(true);
        return repository.save(record);
    }
}
