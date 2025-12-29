package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "branch_profiles",
    uniqueConstraints = @UniqueConstraint(columnNames = "branchCode")
)
public class BranchProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchCode;

    @Size(max = 255)
    private String branchName;

    private String contactEmail;

    private LocalDateTime lastSyncAt;
    private Boolean active;

    /* READ-ONLY relationship */
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private List<AcademicEvent> events = new ArrayList<>();

    public BranchProfile() {}

    public BranchProfile(Long id, String branchCode, String branchName,
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
        if (lastSyncAt == null) lastSyncAt = LocalDateTime.now();
        if (active == null) active = true;
    }

    public Long getId() { return id; }
    public String getBranchCode() { return branchCode; }
    public String getBranchName() { return branchName; }
    public String getContactEmail() { return contactEmail; }
    public LocalDateTime getLastSyncAt() { return lastSyncAt; }
    public Boolean getActive() { return active; }
}
