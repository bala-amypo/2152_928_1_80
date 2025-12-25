package com.example.demo.entity;

import java.time.*;

public class AcademicEvent {

    private Long id;
    private Long branchId;
    private String title;
    private String eventType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private String description;
    private LocalDateTime submittedAt;

    public AcademicEvent() {}

    public AcademicEvent(Long id, Long branchId, String title, String type,
                         LocalDate start, LocalDate end,
                         String location, String desc, LocalDateTime submittedAt) {
        this.id = id;
        this.branchId = branchId;
        this.title = title;
        this.eventType = type;
        this.startDate = start;
        this.endDate = end;
        this.location = location;
        this.description = desc;
        this.submittedAt = submittedAt;
    }

    public void prePersist() {
        if (submittedAt == null) submittedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getBranchId() { return branchId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
}
