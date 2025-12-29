package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import java.time.*;

@Entity
@Table(name = "harmonized_calendars")
public class HarmonizedCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String generatedBy;
    private LocalDateTime generatedAt;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    @Lob
    private String eventsJson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "generatedBy",
        referencedColumnName = "email",
        insertable = false,
        updatable = false
    )
    private UserAccount generator;

    public HarmonizedCalendar() {}

    public HarmonizedCalendar(Long id, String title, String generatedBy,
                              LocalDateTime generatedAt,
                              LocalDate effectiveFrom, LocalDate effectiveTo,
                              String eventsJson) {
        this.id = id;
        this.title = title;
        this.generatedBy = generatedBy;
        this.generatedAt = generatedAt;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
        this.eventsJson = eventsJson;
    }

    @PrePersist
    public void prePersist() {
        if (generatedAt == null) generatedAt = LocalDateTime.now();
    }

    @AssertTrue
    public boolean isEffectiveWindowValid() {
        if (effectiveFrom == null || effectiveTo == null) return true;
        return !effectiveTo.isBefore(effectiveFrom);
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getGeneratedBy() { return generatedBy; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public LocalDate getEffectiveTo() { return effectiveTo; }
    public String getEventsJson() { return eventsJson; }

    public void setTitle(String title) { this.title = title; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }
    public void setEffectiveFrom(LocalDate effectiveFrom) { this.effectiveFrom = effectiveFrom; }
    public void setEffectiveTo(LocalDate effectiveTo) { this.effectiveTo = effectiveTo; }
    public void setEventsJson(String eventsJson) { this.eventsJson = eventsJson; }
}
