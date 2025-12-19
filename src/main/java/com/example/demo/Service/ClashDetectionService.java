package com.example.demo.service;

import com.example.demo.entity.ClashRecordEntity;
import java.util.List;

public interface ClashDetectionService {

    ClashRecordEntity logClash(ClashRecordEntity clash);

    List<ClashRecordEntity> getClashesForEvent(Long eventId);

    ClashRecordEntity resolveClash(Long clashId);

    List<ClashRecordEntity> getUnresolvedClashes();

    List<ClashRecordEntity> getAllClashes();
}
