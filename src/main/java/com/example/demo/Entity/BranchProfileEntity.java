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
