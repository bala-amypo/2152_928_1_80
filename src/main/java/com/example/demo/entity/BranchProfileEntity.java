package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "branchCode"))
public class BranchProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchCode;
    private String branchName;
    private String contactEmail;
    private Boolean active = true;
    private LocalDateTime lastSyncAt;

    @PrePersist
    void onCreate() {
        lastSyncAt = LocalDateTime.now();
    }

    // getters & setters
}
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "branch_profiles")
public class BranchProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String branchCode;

    @Column(nullable = false)
    private String branchName;

    @Column(nullable = false)
    private boolean active = true;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
