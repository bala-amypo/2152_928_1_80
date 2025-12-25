package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;
    private String department;
    private LocalDateTime createdAt;

    public UserAccountEntity() {}

    public UserAccountEntity(Long id, String name, String email, String password,
                             String role, String department, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.role == null) this.role = "REVIEWER";
    }
    private Boolean active;

public Boolean getActive() {
    return active;
}

public void setActive(Boolean active) {
    this.active = active;
}


    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public void setId(Long id) { this.id = id; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
}
