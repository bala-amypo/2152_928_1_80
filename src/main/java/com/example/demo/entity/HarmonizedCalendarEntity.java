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

    // getters and setters
}
