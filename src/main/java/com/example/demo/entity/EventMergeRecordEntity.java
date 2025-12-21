package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;
    private String mergedTitle;

    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;

    private String mergeReason;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private HarmonizedCalendarEntity calendar;

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // getters and setters
}
