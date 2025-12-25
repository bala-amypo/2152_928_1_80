package com.example.demo.entity;

import java.time.*;
import java.time.LocalDate;

public class HarmonizedCalendar {

    private Long id;
    private String title;
    private String generatedBy;
    private LocalDateTime generatedAt;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private String eventsJson;

    public HarmonizedCalendar() {}

    public HarmonizedCalendar(Long id, String title, String by,
                              LocalDateTime genAt,
                              LocalDate from, LocalDate to,
                              String json) {
        this.id = id;
        this.title = title;
        this.generatedBy = by;
        this.generatedAt = genAt;
        this.effectiveFrom = from;
        this.effectiveTo = to;
        this.eventsJson = json;
    }

    public void prePersist() {
        if (generatedAt == null) generatedAt = LocalDateTime.now();
    }

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public String getGeneratedBy() { return generatedBy; }
    public String getTitle() { return title; }
    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public LocalDate getEffectiveTo() { return effectiveTo; }
    public String getEventsJson() { return eventsJson; }
}
