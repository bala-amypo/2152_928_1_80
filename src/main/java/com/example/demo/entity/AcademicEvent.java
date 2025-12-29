package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Size;
import java.time.*;

@Entity
@Table(name = "academic_events")
public class AcademicEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long branchId;

    @Size(max = 255)
    private String title;

    private String eventType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private String description;
    private LocalDateTime submittedAt;

    /* READ-ONLY relationship */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branchId", insertable = false, updatable = false)
    private BranchProfile branch;

    public AcademicEvent() {}

    public AcademicEvent(Long id, Long branchId, String title,
                         String eventType, LocalDate startDate,
                         LocalDate endDate, String location,
                         String description, LocalDateTime submittedAt) {
        this.id = id;
        this.branchId = branchId;
        this.title = title;
        this.eventType = eventType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.description = description;
        this.submittedAt = submittedAt;
    }

    @PrePersist
    public void prePersist() {
        if (submittedAt == null) submittedAt = LocalDateTime.now();
    }

    /* SAFE validation */
    @AssertTrue(message = "End date must not be before start date")
    public boolean isDateRangeValid() {
        if (startDate == null || endDate == null) return true;
        return !endDate.isBefore(startDate);
    }

    public Long getId() { return id; }
    public Long getBranchId() { return branchId; }
    public String getTitle() { return title; }
    public String getEventType() { return eventType; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
}
