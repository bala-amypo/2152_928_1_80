package com.example.demo.service;

import com.example.demo.entity.ClashRecordEntity;
import com.example.demo.repository.ClashRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository repository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logClash(ClashRecordEntity clash) {
        repository.save(clash);
    }

    @Override
    public List<ClashRecordEntity> getClashesForEvent(Long eventId) {
        return repository.findByEventAIdOrEventBId(eventId, eventId);
    }

    @Override
    public void resolveClash(Long clashId) {
        ClashRecordEntity clash = repository.findById(clashId)
            .orElseThrow(() -> new RuntimeException("Clash not found"));
        clash.setResolved(true);
        repository.save(clash);
    }

    @Override
    public List<ClashRecordEntity> getUnresolvedClashes() {
        return repository.findByResolvedFalse();
    }

    @Override
    public List<ClashRecordEntity> getAllClashes() {
        return repository.findAll();
    }
}
