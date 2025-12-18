BranchProfile.java 

package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class BranchProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String branchCode;

    private String branchName;
    private String contactEmail;
    private boolean active;
    private LocalDateTime lastSyncAt;

    // ✅ No-args constructor
    public BranchProfile() {
    }

    // ✅ All-args constructor
    public BranchProfile(Long id, String branchCode, String branchName,
                         String contactEmail, boolean active, LocalDateTime lastSyncAt) {
        this.id = id;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.contactEmail = contactEmail;
        this.active = active;
        this.lastSyncAt = lastSyncAt;
    }

    @PrePersist
    public void onCreate() {
        this.lastSyncAt = LocalDateTime.now();
        this.active = true;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getLastSyncAt() { return lastSyncAt; }
    public void setLastSyncAt(LocalDateTime lastSyncAt) { this.lastSyncAt = lastSyncAt; }
}