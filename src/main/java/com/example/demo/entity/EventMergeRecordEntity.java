package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

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
    private LocalDateTime createdAt;

    public EventMergeRecordEntity() {}

    public EventMergeRecordEntity(Long id, String sourceEventIds, String mergedTitle,
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
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getSourceEventIds() { return sourceEventIds; }
    public void setId(Long id) { this.id = id; }
    public void setSourceEventIds(String ids) { this.sourceEventIds = ids; }
    public void setMergedTitle(String t) { this.mergedTitle = t; }
    public void setMergedStartDate(LocalDate d) { this.mergedStartDate = d; }
    public void setMergedEndDate(LocalDate d) { this.mergedEndDate = d; }
    public void setMergeReason(String r) { this.mergeReason = r; }
}
