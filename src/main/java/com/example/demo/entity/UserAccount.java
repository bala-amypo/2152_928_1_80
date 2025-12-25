package com.example.demo.entity;

import java.time.LocalDateTime;

public class UserAccount {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String department;
    private LocalDateTime createdAt;

    // ---------- Constructors ----------

    public UserAccount() {
    }

    public UserAccount(Long id,
                       String name,
                       String email,
                       String password,
                       String role,
                       String department,
                       LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.createdAt = createdAt;
    }

    // ---------- Lifecycle Logic ----------

    /**
     * Simulates JPA @PrePersist behavior
     * (used directly in unit tests)
     */
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        if (this.role == null) {
            this.role = "REVIEWER";
        }
    }

    // ---------- Getters ----------

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    /** ✅ REQUIRED BY UserAccountServiceImpl */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ---------- Setters ----------

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
