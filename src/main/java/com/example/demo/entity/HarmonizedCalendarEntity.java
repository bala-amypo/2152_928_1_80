package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "harmonized_calendar")
public class HarmonizedCalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime generatedAt;

    @Column(nullable=false)
    private String generatedBy;

    // ❗ If you store user in DB as entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generated_by_user_id", referencedColumnName = "id")
    private UserAccountEntity generatedByUser;

    // One generated calendar may produce merge logs
    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventMergeRecordEntity> mergeRecords;

    /* ========= getters + setters ========= */

    public Long getId() {
        return id;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
    

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public UserAccountEntity getGeneratedByUser() {
        return generatedByUser;
    }

    public void setGeneratedByUser(UserAccountEntity generatedByUser) {
        this.generatedByUser = generatedByUser;
    }

    public List<EventMergeRecordEntity> getMergeRecords() {
        return mergeRecords;
    }

    public void setMergeRecords(List<EventMergeRecordEntity> mergeRecords) {
        this.mergeRecords = mergeRecords;
    }

    @PrePersist
    public void prePersist() {
        generatedAt = LocalDateTime.now();
    }
}
