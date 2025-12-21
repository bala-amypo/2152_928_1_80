package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "branch_profiles",
        uniqueConstraints = @UniqueConstraint(columnNames = "branchCode")
)
public class BranchProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Branch code required")
    @Column(nullable = false, unique = true)
    private String branchCode;

    @NotBlank(message = "Branch name required")
    @Column(nullable = false)
    private String branchName;

    @Column(nullable = false)
    private boolean active = true;

    private LocalDateTime lastSyncAt;

    // One branch has many events
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<AcademicEventEntity> events;

    @PrePersist
    void onCreate() {
        lastSyncAt = LocalDateTime.now();
    }

    // getters and setters
}
