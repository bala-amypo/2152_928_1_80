package com.example.demo.entity;

import com.example.demo.exception.ValidationException;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "academic_events")
public class AcademicEventEntity {

    @Id
    @NotBlank(message = "Title required")
    private String title;

    @NotNull(message = "Branch required")
    @Column(nullable = false)
    private Long branchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branchId", insertable = false, updatable = false)
    private BranchProfileEntity branch;

    @NotBlank(message = "Event type required")
    private String eventType;

    @NotNull(message = "Start date required")
    private LocalDate startDate;

    @NotNull(message = "End date required")
    private LocalDate endDate;

    private String location;

    @Size(max = 500)
    private String description;

    private LocalDateTime submittedAt;

    @PrePersist
    public void validate() {
        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new ValidationException("Start date cannot be after end date");
        }
        submittedAt = LocalDateTime.now();
    }

    // getters and setters
}
