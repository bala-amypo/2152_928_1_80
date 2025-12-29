package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.*;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;

    @Size(max = 255)
    private String mergedTitle;

    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;
    private LocalDateTime createdAt;

    public EventMergeRecord() {}

    public EventMergeRecord(Long id, String sourceEventIds, String mergedTitle,
                            LocalDate mergedStartDate, LocalDate mergedEndDate,
                            String mergeReason, LocalDateTime createdAt) {
        this.id = id;
        this.sourceEventIds = sourceEventIds;
        this.mergedTitle = mergedTitle;
        this.mergedStartDate = mergedStartDate;
        this.mergedEndDate = mergedEndDate;
        this.mergeReason = mergeReason;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getSourceEventIds() { return sourceEventIds; }
    public String getMergedTitle() { return mergedTitle; }
    public LocalDate getMergedStartDate() { return mergedStartDate; }
    public LocalDate getMergedEndDate() { return mergedEndDate; }
    public String getMergeReason() { return mergeReason; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
