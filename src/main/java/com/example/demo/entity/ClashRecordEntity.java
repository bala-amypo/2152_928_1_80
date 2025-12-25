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
    private String clashType;
    private String severity;
    private String description;
    private LocalDateTime detectedAt;
    private Boolean resolved;

    public ClashRecordEntity() {}

    public ClashRecordEntity(Long id, Long a, Long b, String type,
                             String severity, String desc,
                             LocalDateTime dt, Boolean resolved) {
        this.id = id;
        this.eventAId = a;
        this.eventBId = b;
        this.clashType = type;
        this.severity = severity;
        this.description = desc;
        this.detectedAt = dt;
        this.resolved = resolved;
    }

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
        if (this.resolved == null) this.resolved = false;
    }

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
