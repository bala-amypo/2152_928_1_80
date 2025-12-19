package com.example.demo.service;

import com.example.demo.Repository.ClashRecordRepository;
import com.example.demo.entity.ClashRecordEntity;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository repository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClashRecordEntity logClash(ClashRecordEntity clash) {
        return repository.save(clash);
    }

    @Override
    public List<ClashRecordEntity> getClashesForEvent(Long eventId) {
        return repository.findByEventAIdOrEventBId(eventId, eventId);
    }

    @Override
    public List<ClashRecordEntity> getUnresolvedClashes() {
        return repository.findByResolved(false);
    }

    @Override
    public void resolveClash(Long clashId) {
        ClashRecordEntity clash = repository.findById(clashId)
                .orElseThrow(() -> new ResourceNotFoundException("Clash not found with id " + clashId));
        clash.setResolved(true);
        repository.save(clash);
    }

    @Override
    public List<ClashRecordEntity> getAllClashes() {
        return repository.findAll();
    }
}
