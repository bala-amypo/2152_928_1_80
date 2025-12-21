package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "branchCode"))
public class BranchProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String branchCode;

    @NotBlank
    private String branchName;

    private boolean active = true;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private LocalDateTime lastSyncAt;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AcademicEventEntity> events;

    @PrePersist
    public void onCreate() {
        if (lastSyncAt == null) {
            lastSyncAt = LocalDateTime.now();
        }
    }

    // --- getters + setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }
    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public LocalDateTime getLastSyncAt() { return lastSyncAt; }
    public void setLastSyncAt(LocalDateTime lastSyncAt) { this.lastSyncAt = lastSyncAt; }
    public List<AcademicEventEntity> getEvents() { return events; }
    public void setEvents(List<AcademicEventEntity> events) { this.events = events; }
}
