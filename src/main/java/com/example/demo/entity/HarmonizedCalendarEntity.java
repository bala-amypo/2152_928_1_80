package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "harmonized_calendar")
public class HarmonizedCalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Calendar title is required")
    private String title;

    @NotNull(message = "Effective From date is required")
    private LocalDate effectiveFrom;

    @NotNull(message = "Effective To date is required")
    private LocalDate effectiveTo;

    private LocalDateTime generatedAt;

    /** 
     * If you want only String name of user who generated it 
     * use this field
     */
    @NotBlank
    private String generatedBy;

    /**
     * If you store users in DB - better mapping
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generated_by_user_id")
    private UserAccountEntity generatedByUser;

    /**
     * One calendar may produce many event merge records
     */
    @
    (mappedBy = "calendar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventMergeRecordEntity> mergeRecords;

    /* ================= GETTERS / SETTERS ================= */

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public LocalDate getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(LocalDate effectiveTo) {
        this.effectiveTo = effectiveTo;
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
        if (generatedAt == null) {
            generatedAt = LocalDateTime.now();
        }
    }

}
