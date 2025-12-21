package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clash_records")
public class ClashRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventAId;
    private Long eventBId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventAId", insertable = false, updatable = false)
    private AcademicEventEntity eventA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventBId", insertable = false, updatable = false)
    private AcademicEventEntity eventB;

    private String clashType;
    private String severity;
    private String details;

    private LocalDateTime detectedAt;

    private Boolean resolved = false;

    @PrePersist
    protected void onCreate() {
        detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    // getters and setters
}
