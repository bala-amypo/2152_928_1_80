package com.example.demo.entity;

import java.time.*;

public class EventMergeRecord {

    private Long id;
    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;
    private LocalDateTime createdAt;

    public EventMergeRecord() {}

    public EventMergeRecord(Long id, String src, String title,
                            LocalDate start, LocalDate end,
                            String reason, LocalDateTime createdAt) {
        this.id = id;
        this.sourceEventIds = src;
        this.mergedTitle = title;
        this.mergedStartDate = start;
        this.mergedEndDate = end;
        this.mergeReason = reason;
        this.createdAt = createdAt;
    }

    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public String getSourceEventIds() { return sourceEventIds; }
}
