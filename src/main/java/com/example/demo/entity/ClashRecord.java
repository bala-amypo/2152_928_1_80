package com.example.demo.entity;

import java.time.*;

public class ClashRecord {

    private Long id;
    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private LocalDateTime detectedAt;
    private Boolean resolved;

    public ClashRecord() {}

    public ClashRecord(Long id, Long a, Long b, String t,
                       String s, String d,
                       LocalDateTime at, Boolean r) {
        this.id = id;
        this.eventAId = a;
        this.eventBId = b;
        this.clashType = t;
        this.severity = s;
        this.detectedAt = at;
        this.resolved = r;
    }

    public void prePersist() {
        if (detectedAt == null) detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    // setters
    public void setEventAId(Long v) { eventAId = v; }
    public void setEventBId(Long v) { eventBId = v; }
    public void setClashType(String v) { clashType = v; }
    public void setSeverity(String v) { severity = v; }
    public void setResolved(Boolean v) { resolved = v; }

    // getters
    public Long getEventAId() { return eventAId; }
    public Long getEventBId() { return eventBId; }
    public Boolean getResolved() { return resolved; }
    public LocalDateTime getDetectedAt() { return detectedAt; }
}
