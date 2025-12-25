package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "branch_profiles")
public class BranchProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchCode;
    private String branchName;
    private String contactEmail;
    private LocalDateTime lastSyncAt;
    private Boolean active;

    @Transient
    private List<AcademicEventEntity> events = new ArrayList<>();

    public BranchProfileEntity() {}

    public BranchProfileEntity(Long id, String branchCode, String branchName,
                               String contactEmail, LocalDateTime lastSyncAt,
                               Boolean active) {
        this.id = id;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.contactEmail = contactEmail;
        this.lastSyncAt = lastSyncAt;
        this.active = active;
    }

    @PrePersist
    public void prePersist() {
        this.lastSyncAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }

    // ===== GETTERS / SETTERS =====

    public Long getId() {
        return id;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public Boolean getActive() {
        return active;
    }

    public List<AcademicEventEntity> getEvents() {
        return events;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
