package com.example.demo.entity;

import jakarta.persistence.*;
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

    private Boolean resolved = false;

    private LocalDateTime createdAt;

    public ClashRecordEntity() {}

    public ClashRecordEntity(Long eventAId, Long eventBId) {
        this.eventAId = eventAId;
        this.eventBId = eventBId;
        this.resolved = false;
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public Long getEventAId() { return eventAId; }
    public void setEventAId(Long eventAId) { this.eventAId = eventAId; }
    public Long getEventBId() { return eventBId; }
    public void setEventBId(Long eventBId) { this.eventBId = eventBId; }
    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
