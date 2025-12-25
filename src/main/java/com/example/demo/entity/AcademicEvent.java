package com.example.demo.entity;

import java.time.*;

public class AcademicEvent {

    private Long id;
    private Long branchId;
    private String title;
    private String eventType;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime submittedAt;

    public AcademicEvent() {}

    public AcademicEvent(Long id, Long branchId, String title,
                         String type, LocalDate s, LocalDate e,
                         String l, String d, LocalDateTime at) {
        this.id = id;
        this.branchId = branchId;
        this.title = title;
        this.eventType = type;
        this.startDate = s;
        this.endDate = e;
        this.submittedAt = at;
    }

    public void prePersist() {
        if (submittedAt == null) submittedAt = LocalDateTime.now();
    }

    // setters
    public void setBranchId(Long v) { branchId = v; }
    public void setTitle(String v) { title = v; }
    public void setEventType(String v) { eventType = v; }
    public void setStartDate(LocalDate v) { startDate = v; }
    public void setEndDate(LocalDate v) { endDate = v; }

    // getters
    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public Long getBranchId() { return branchId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
}
