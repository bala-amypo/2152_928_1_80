package com.example.demo.entity;

import com.example.demo.exception.ValidationException;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "academic_events")
public class AcademicEventEntity {

    @Id
    private String title;   // Primary Key

    @Column(nullable = false)
    private Long branchId;  // Required for repository query

    private String eventType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private String description;
    private LocalDateTime submittedAt;

    // -------- Getters & Setters --------

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    // -------- Validation --------

    @PrePersist
    public void validate() {
        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new ValidationException("Start date cannot be after end date");
        }
        submittedAt = LocalDateTime.now();
    }
}
