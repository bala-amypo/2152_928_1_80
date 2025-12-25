package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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

    public BranchProfileEntity() {}

    public BranchProfileEntity(Long id, String branchCode, String branchName,
                               String contactEmail, LocalDateTime lastSyncAt, Boolean active) {
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
        if (this.active == null) this.active = true;
    }

    public Long getId() { return id; }
    public Boolean getActive() { return active; }
    public String getBranchCode() { return branchCode; }
    public void setActive(Boolean active) { this.active = active; }
}
