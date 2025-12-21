package com.example.demo.service;

import com.example.demo.entity.ClashRecordEntity;
import java.util.List;

public interface ClashDetectionService {
    List<ClashRecordEntity> getAllClashRecords();
    ClashRecordEntity getClashRecordById(Long id);
    ClashRecordEntity saveClashRecord(ClashRecordEntity record);
    List<ClashRecordEntity> getByResolved(Boolean resolved);
}
