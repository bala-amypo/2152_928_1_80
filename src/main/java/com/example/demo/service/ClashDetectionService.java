package com.example.demo.service;

import com.example.demo.entity.ClashRecordEntity;

import java.util.List;

public interface ClashRecordService {

    ClashRecordEntity logClash(ClashRecordEntity clash);

    ClashRecordEntity resolveClash(Long clashId);

    List<ClashRecordEntity> getClashesForEvent(Long eventId);

    List<ClashRecordEntity> getUnresolvedClashes();

    List<ClashRecordEntity> getAllClashes();
}
