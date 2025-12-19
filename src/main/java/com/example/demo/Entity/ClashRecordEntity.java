package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClashRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String details;
    private Boolean resolved = false;
    private LocalDateTime detectedAt;

    @PrePersist
    void onCreate() {
        detectedAt = LocalDateTime.now();
    }
}
