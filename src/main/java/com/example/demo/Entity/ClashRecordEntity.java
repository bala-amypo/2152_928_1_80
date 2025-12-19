package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "clash_records")
public class ClashRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long eventAId;

    @NotNull
    private Long eventBId;

    @NotBlank
    private String clashType;

    @NotBlank
    private String severity;

    private String details;

    private LocalDateTime detectedAt;

    private Boolean resolved = false;

    @PrePersist
    protected void onCreate() {
        this.detectedAt = LocalDateTime.now();
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Long getEventAId() { return eventAId; }
    public Long getEventBId() { return eventBId; }
    public String getClashType() { return clashType; }
    public String getSeverity() { return severity; }
    public String getDetails() { return details; }
    public LocalDateTime getDetectedAt() { return detectedAt; }
    public Boolean getResolved() { return resolved; }

    public void setId(Long id) { this.id = id; }
    public void setEventAId(Long eventAId) { this.eventAId = eventAId; }
    public void setEventBId(Long eventBId) { this.eventBId = eventBId; }
    public void setClashType(String clashType) { this.clashType = clashType; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setDetails(String details) { this.details = details; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
