package com.example.demo.entity;

import java.time.*;

public class ClashRecord {

    private Long id;
    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String description;
    private LocalDateTime detectedAt;
    private Boolean resolved;

    public ClashRecord() {}

    public ClashRecord(Long id, Long a, Long b, String type,
                       String severity, String desc,
                       LocalDateTime detectedAt, Boolean resolved) {
        this.id = id;
        this.eventAId = a;
        this.eventBId = b;
        this.clashType = type;
        this.severity = severity;
        this.description = desc;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    public void prePersist() {
        if (detectedAt == null) detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    public Boolean getResolved() { return resolved; }
}
