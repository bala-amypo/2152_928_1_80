package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clash_records")
public class ClashRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventAId;
    private Long eventBId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventAId", insertable = false, updatable = false)
    private AcademicEventEntity eventA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventBId", insertable = false, updatable = false)
    private AcademicEventEntity eventB;

    private String clashType;
    private String severity;
    private String details;

    private LocalDateTime detectedAt;
    private Boolean resolved = false;

    @PrePersist
    protected void onCreate() {
        detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    // getters + setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEventAId() { return eventAId; }
    public void setEventAId(Long eventAId) { this.eventAId = eventAId; }

    public Long getEventBId() { return eventBId; }
    public void setEventBId(Long eventBId) { this.eventBId = eventBId; }

    public AcademicEventEntity getEventA() { return eventA; }
    public void setEventA(AcademicEventEntity eventA) { this.eventA = eventA; }

    public AcademicEventEntity getEventB() { return eventB; }
    public void setEventB(AcademicEventEntity eventB) { this.eventB = eventB; }

    public String getClashType() { return clashType; }
    public void setClashType(String clashType) { this.clashType = clashType; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
    public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
