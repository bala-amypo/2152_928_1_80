package com.example.demo.service;

import com.example.demo.entity.ClashRecordEntity;
import java.util.List;

public interface ClashDetectionService {
    void logClash(ClashRecordEntity clash);
    List<ClashRecordEntity> getClashesForEvent(Long eventId);
    void resolveClash(Long clashId);
    List<ClashRecordEntity> getUnresolvedClashes();
    List<ClashRecordEntity> getAllClashes();
}
