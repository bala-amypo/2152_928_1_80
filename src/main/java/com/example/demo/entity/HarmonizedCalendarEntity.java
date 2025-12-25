package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class HarmonizedCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
                              LocalDate from, LocalDate to, String json) {
        this.id = id;
        this.title = title;
        this.generatedBy = by;
        this.generatedAt = genAt;
        this.effectiveFrom = from;
        this.effectiveTo = to;
        this.eventsJson = json;
    }

    @PrePersist
    public void prePersist() {
        this.generatedAt = LocalDateTime.now();
    }

    // getters/setters
    public Long getId() { return id; }
    public String getGeneratedBy() { return generatedBy; }
    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public LocalDate getEffectiveTo() { return effectiveTo; }
    public String getEventsJson() { return eventsJson; }
    public void setId(Long id) { this.id = id; }
    public void setTitle(String t) { this.title = t; }
    public void setGeneratedBy(String g) { this.generatedBy = g; }
    public void setEffectiveFrom(LocalDate d) { this.effectiveFrom = d; }
    public void setEffectiveTo(LocalDate d) { this.effectiveTo = d; }
    public void setEventsJson(String j) { this.eventsJson = j; }
}
