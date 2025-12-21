package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String fullName;

    @NotBlank
    @Email(message = "Invalid email")
    private String email;

    // password optional now
    @JsonIgnore
    private String password;

    private String role = "USER";
    private String department;
    private boolean active = true;
    private LocalDateTime createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "generatedByUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HarmonizedCalendarEntity> calendars = new ArrayList<>();

    public UserAccountEntity() {}

    @PrePersist
    void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<HarmonizedCalendarEntity> getCalendars() { return calendars; }
    public void setCalendars(List<HarmonizedCalendarEntity> calendars) { this.calendars = calendars; }
}
