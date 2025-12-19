package com.example.demo.serviceimpl;

import com.example.demo.entity.ClashRecordEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
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
        return repository.findAll().stream()
                .filter(c ->
                        c.getEventAId().equals(eventId)
                     || c.getEventBId().equals(eventId))
                .toList();
    }

    @Override
    public ClashRecordEntity resolveClash(Long clashId) {
        ClashRecordEntity clash = repository.findById(clashId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Clash not found"));

        clash.setResolved(true);
        return repository.save(clash);
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
