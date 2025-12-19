package com.example.demo.service;

import com.example.demo.entity.EventMergeRecordEntity;
import java.time.LocalDate;
import java.util.List;

public interface EventMergeService {

    EventMergeRecordEntity mergeEvents(List<Long> eventIds, String reason);

    List<EventMergeRecordEntity> getAllMergeRecords();

    EventMergeRecordEntity getMergeRecordById(Long id);

    List<EventMergeRecordEntity> getMergeRecordsByDate(LocalDate start, LocalDate end);
}
