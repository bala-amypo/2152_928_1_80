package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecordEntity;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository clashRecordRepository;

    public ClashDetectionServiceImpl(ClashRecordRepository clashRecordRepository) {
        this.clashRecordRepository = clashRecordRepository;
    }

    @Override
    public List<ClashRecordEntity> getAllClashRecords() {
        return clashRecordRepository.findAll();
    }

    @Override
    public ClashRecordEntity getClashRecordById(Long id) {
        return clashRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClashRecord not found"));
    }

    @Override
    public ClashRecordEntity saveClashRecord(ClashRecordEntity record) {
        return clashRecordRepository.save(record);
    }

    @Override
    public List<ClashRecordEntity> getByResolved(Boolean resolved) {
        return clashRecordRepository.findByResolved(resolved);
    }
}
