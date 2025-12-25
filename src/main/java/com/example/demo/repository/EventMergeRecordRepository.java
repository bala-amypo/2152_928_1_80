package com.example.demo.repository;

import com.example.demo.entity.EventMergeRecord;
import java.time.LocalDate;   // ✅ ADD THIS
import java.util.List;

public interface EventMergeRecordRepository {

    EventMergeRecord save(EventMergeRecord e);

    List<EventMergeRecord> findByMergedStartDateBetween(
            LocalDate start,
            LocalDate end
    );
}
