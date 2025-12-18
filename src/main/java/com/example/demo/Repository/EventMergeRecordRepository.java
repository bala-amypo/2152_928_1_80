package com.example.demo.Repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.EventMergeRecordEntity;

public interface EventMergeRecordRepository
        extends JpaRepository<EventMergeRecordEntity, Long> {

    List<EventMergeRecordEntity> findByCreatedAtBetween(
            LocalDateTime start, LocalDateTime end);
}