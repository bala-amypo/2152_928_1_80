package com.example.demo.entity;

import java.time.LocalDateTime;

public class BranchProfile {

    private Long id;
    private String branchCode;
    private String branchName;
    private String contactEmail;
    private LocalDateTime lastSyncAt;
    private Boolean active;

    public BranchProfile() {}

    public BranchProfile(Long id, String code, String name,
                         String email, LocalDateTime lastSyncAt,
                         Boolean active) {
        this.id = id;
        this.branchCode = code;
        this.branchName = name;
        this.contactEmail = email;
        this.lastSyncAt = lastSyncAt;
        this.active = active;
    }

    public void prePersist() {
        if (lastSyncAt == null) lastSyncAt = LocalDateTime.now();
        if (active == null) active = true;
    }

    // getters & setters
    public void setBranchCode(String v) { branchCode = v; }
    public void setBranchName(String v) { branchName = v; }
    public void setContactEmail(String v) { contactEmail = v; }
    public LocalDateTime getLastSyncAt() { return lastSyncAt; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean a) { active = a; }
    public String getBranchCode() { return branchCode; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
