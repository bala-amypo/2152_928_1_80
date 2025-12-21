package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name required")
    private String fullName;

    @NotBlank(message = "Email required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank
    @Size(min = 6, message = "Password must be 6+ characters")
    private String password;

    @NotBlank
    private String role;

    private String department;

    private LocalDateTime createdAt;

    private boolean active;

    @OneToMany(mappedBy = "generatedByUser")
    private List<HarmonizedCalendarEntity> generatedCalendars;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // getters and setters
}
