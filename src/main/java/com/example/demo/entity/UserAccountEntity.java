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

    @NotBlank(message="Name required")
    private String fullName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private String role;
    private String department;

    private boolean active = true;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "generatedByUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HarmonizedCalendarEntity> calendars;

    @PrePersist
    void created() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    // --- getters + setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName(){ return fullName; }
    public void setFullName(String fullName){ this.fullName=fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword(){ return password; }
    public void setPassword(String password){ this.password = password; }

    public boolean isActive(){ return active; }
    public void setActive(boolean active){ this.active = active; }

    public String getRole(){ return role; }
    public void setRole(String role){ this.role = role; }

    public String getDepartment(){ return department; }
    public void setDepartment(String department){ this.department=department; }

    public LocalDateTime getCreatedAt(){ return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt){ this.createdAt = createdAt; }

    public List<HarmonizedCalendarEntity> getCalendars() { return calendars; }
    public void setCalendars(List<HarmonizedCalendarEntity> calendars) { this.calendars = calendars; }
}
