package com.example.demo.service;

import com.example.demo.entity.ClashRecordEntity;

import java.util.List;

public interface ClashDetectionService {

    ClashRecordEntity logClash(ClashRecordEntity clash);

    List<ClashRecordEntity> getClashesForEvent(Long eventId);

    List<ClashRecordEntity> getUnresolvedClashes();

    void resolveClash(Long clashId);

    List<ClashRecordEntity> getAllClashes();
}
