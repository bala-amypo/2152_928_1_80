package com.example.demo.entity;

import java.time.*;

public class HarmonizedCalendar {

    private Long id;
    private String title;
    private String generatedBy;
    private LocalDateTime generatedAt;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private String eventsJson;

    public HarmonizedCalendar() {}

    public HarmonizedCalendar(Long id, String t, String by,
                              LocalDateTime at,
                              LocalDate f, LocalDate to,
                              String json) {
        this.id = id;
        this.title = t;
        this.generatedBy = by;
        this.generatedAt = at;
        this.effectiveFrom = f;
        this.effectiveTo = to;
        this.eventsJson = json;
    }

    public void prePersist() {
        if (generatedAt == null) generatedAt = LocalDateTime.now();
    }

    // setters
    public void setGeneratedBy(String v) { generatedBy = v; }
    public void setEffectiveFrom(LocalDate v) { effectiveFrom = v; }
    public void setEffectiveTo(LocalDate v) { effectiveTo = v; }

    // getters
    public String getTitle() { return title; }
    public String getGeneratedBy() { return generatedBy; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public LocalDate getEffectiveTo() { return effectiveTo; }
    public String getEventsJson() { return eventsJson; }
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
}
