package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "academic_events")
public class AcademicEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long branchId;
    private String title;
    private String eventType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String venue;
    private String description;
    private LocalDateTime submittedAt;

    // Dummy reference required by service (NOT persisted)
    @Transient
    private BranchProfileEntity branch;

    public AcademicEventEntity() {}

    public AcademicEventEntity(Long id, Long branchId, String title, String eventType,
                               LocalDate startDate, LocalDate endDate,
                               String venue, String description, LocalDateTime submittedAt) {
        this.id = id;
        this.branchId = branchId;
        this.title = title;
        this.eventType = eventType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.venue = venue;
        this.description = description;
        this.submittedAt = submittedAt;
    }

    @PrePersist
    public void prePersist() {
        this.submittedAt = LocalDateTime.now();
    }

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public Long getBranchId() {
        return branchId;
    }

    public String getEventType() {
        return eventType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return venue;
    }

    public String getDescription() {
        return description;
    }

    // ===== SETTERS REQUIRED BY SERVICES =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setLocation(String location) {
        // service uses "location", entity stores it as "venue"
        this.venue = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ===== Dummy setter required by BranchProfileServiceImpl =====

    public void setBranch(BranchProfileEntity branch) {
        this.branch = branch;
    }
}
