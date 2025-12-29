package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "clash_records")
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String details;
    private LocalDateTime detectedAt;
    private Boolean resolved;

    /* READ-ONLY relationships */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventAId", insertable = false, updatable = false)
    private AcademicEvent eventA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventBId", insertable = false, updatable = false)
    private AcademicEvent eventB;

    public ClashRecord() {}

    public ClashRecord(Long id, Long eventAId, Long eventBId,
                       String clashType, String severity,
                       String details, LocalDateTime detectedAt,
                       Boolean resolved) {
        this.id = id;
        this.eventAId = eventAId;
        this.eventBId = eventBId;
        this.clashType = clashType;
        this.severity = severity;
        this.details = details;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    @PrePersist
    public void prePersist() {
        if (detectedAt == null) detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    public Long getId() { return id; }
    public Long getEventAId() { return eventAId; }
    public Long getEventBId() { return eventBId; }
    public String getClashType() { return clashType; }
    public String getSeverity() { return severity; }
    public String getDetails() { return details; }
    public LocalDateTime getDetectedAt() { return detectedAt; }
    public Boolean getResolved() { return resolved; }
}
