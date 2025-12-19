package com.example.demo.serviceimpl;

import com.example.demo.entity.ClashRecordEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClashRecordServiceImpl implements ClashRecordService {

    private final ClashRecordRepository repository;

    public ClashRecordServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClashRecordEntity logClash(ClashRecordEntity clash) {
        return repository.save(clash);
    }

    @Override
    public ClashRecordEntity resolveClash(Long clashId) {
        ClashRecordEntity clash = repository.findById(clashId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "ClashRecord not found with id " + clashId));

        clash.setResolved(true);
        return repository.save(clash);
    }

    @Override
    public List<ClashRecordEntity> getClashesForEvent(Long eventId) {
        return repository.findByEventAIdOrEventBId(eventId, eventId);
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
