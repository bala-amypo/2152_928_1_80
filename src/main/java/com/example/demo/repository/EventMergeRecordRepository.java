package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;
public interface EventMergeRecordRepository {
    EventMergeRecord save(EventMergeRecord e);
    List<EventMergeRecord> findByMergedStartDateBetween(LocalDate s, LocalDate e);
}
