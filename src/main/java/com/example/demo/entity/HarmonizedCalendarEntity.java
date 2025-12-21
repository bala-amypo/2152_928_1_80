package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "harmonized_calendars")
public class HarmonizedCalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "generatedBy")
    private UserAccountEntity generatedByUser;

    private LocalDateTime generatedAt;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    @Lob
    private String eventsJson;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<EventMergeRecordEntity> mergeRecords;

    @PrePersist
    void onCreate() {
        generatedAt = LocalDateTime.now();
    }

    // getters + setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public UserAccountEntity getGeneratedByUser() { return generatedByUser; }
    public void setGeneratedByUser(UserAccountEntity generatedByUser) { this.generatedByUser = generatedByUser; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }

    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public void setEffectiveFrom(LocalDate effectiveFrom) { this.effectiveFrom = effectiveFrom; }

    public LocalDate getEffectiveTo() { return effectiveTo; }
    public void setEffectiveTo(LocalDate effectiveTo) { this.effectiveTo = effectiveTo; }

    public String getEventsJson() { return eventsJson; }
    public void setEventsJson(String eventsJson) { this.eventsJson = eventsJson; }

    public List<EventMergeRecordEntity> getMergeRecords() { return mergeRecords; }
    public void setMergeRecords(List<EventMergeRecordEntity> mergeRecords) { this.mergeRecords = mergeRecords; }
}
