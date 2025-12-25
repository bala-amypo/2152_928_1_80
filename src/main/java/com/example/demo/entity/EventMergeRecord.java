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

    public EventMergeRecord(Long id, String src, String t,
                            LocalDate s, LocalDate e,
                            String r, LocalDateTime c) {
        this.id = id;
        this.sourceEventIds = src;
        this.mergedTitle = t;
        this.mergedStartDate = s;
        this.mergedEndDate = e;
        this.mergeReason = r;
        this.createdAt = c;
    }

    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    // setters
    public void setSourceEventIds(String v) { sourceEventIds = v; }
    public void setMergedTitle(String v) { mergedTitle = v; }
    public void setMergedStartDate(LocalDate v) { mergedStartDate = v; }
    public void setMergedEndDate(LocalDate v) { mergedEndDate = v; }
    public void setMergeReason(String v) { mergeReason = v; }

    // getters
    public String getSourceEventIds() { return sourceEventIds; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
}
