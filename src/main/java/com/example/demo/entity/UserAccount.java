package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "user_accounts",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role;
    private String department;

    private LocalDateTime createdAt;

    /* READ-ONLY relationship (SAFE) */
    @OneToMany(mappedBy = "generator", fetch = FetchType.LAZY)
    private List<HarmonizedCalendar> calendars;

    public UserAccount() {}

    public UserAccount(Long id, String fullName, String email,
                       String password, String role,
                       String department, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (role == null) role = "REVIEWER";
    }

    /* GETTERS */
    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getDepartment() { return department; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<HarmonizedCalendar> getCalendars() { return calendars; }

    /* SETTERS */
    public void setId(Long id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setDepartment(String department) { this.department = department; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setCalendars(List<HarmonizedCalendar> calendars) {
        this.calendars = calendars;
    }
}
