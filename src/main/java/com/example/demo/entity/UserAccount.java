package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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

    @Size(max = 255)
    private String fullName;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role;
    private String department;

    private LocalDateTime createdAt;

    /* READ-ONLY relationship */
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

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getDepartment() { return department; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
