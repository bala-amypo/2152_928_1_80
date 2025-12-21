package com.example.demo.repository;

import com.example.demo.entity.EventMergeRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventMergeRecordRepository
        extends JpaRepository<EventMergeRecordEntity, Long> {
}
