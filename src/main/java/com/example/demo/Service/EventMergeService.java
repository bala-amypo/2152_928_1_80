package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.Entity.EventMergeRecordEntity;

public interface EventMergeService {

    EventMergeRecordEntity mergeEvents(List<Long> eventIds, String reason);

    EventMergeRecordEntity getMergeRecordById(Long id);

    List<EventMergeRecordEntity> getAllMergeRecords();

    List<EventMergeRecordEntity> getMergeRecordsByDate(LocalDate start, LocalDate end);
}