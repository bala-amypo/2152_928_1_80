package com.example.demo.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class ClashRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private String clashType;
    private String severity;
    private String details;
    private LocalDateTime detectedAt;
    private boolean resolved;

    public ClashRecordEntity() {
    }

    public ClashRecordEntity(Long id, Long eventId, String clashType, String severity,String details, LocalDateTime detectedAt, boolean resolved) {
        this.id = id;
        this.eventId = eventId;
        this.clashType = clashType;
        this.severity = severity;
        this.details = details;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    @PrePersist
    public void onCreate() {
        this.detectedAt = LocalDateTime.now();
        this.resolved = false;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public String getClashType() { return clashType; }
    public void setClashType(String clashType) { this.clashType = clashType; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public LocalDateTime getDetectedAt() { return detectedAt; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}