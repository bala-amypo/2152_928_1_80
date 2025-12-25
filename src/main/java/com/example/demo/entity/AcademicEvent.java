package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class AcademicEvent {

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

    public AcademicEvent() {}

    public AcademicEvent(Long id, Long branchId, String title, String eventType,
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

    // getters
    public Long getId() { return id; }
    public Long getBranchId() { return branchId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setId(Long id) { this.id = id; }
}
