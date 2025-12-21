package com.example.demo.service;

import com.example.demo.repository.ClashRecordRepository; // ✅ lowercase 'repository'
import com.example.demo.entity.ClashRecordEntity;
import org.springframework.stereotype.Service;

@Service
public class ClashDetectionServiceImpl {

    private final ClashRecordRepository clashRecordRepository;

    public ClashDetectionServiceImpl(ClashRecordRepository clashRecordRepository) {
        this.clashRecordRepository = clashRecordRepository;
    }

    // Example method
    public void someMethod() {
        // use clashRecordRepository
    }
}
    