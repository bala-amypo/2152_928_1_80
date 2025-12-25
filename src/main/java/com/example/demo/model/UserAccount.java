package com.example.demo.model;

public class UserAccount {

    private Long id;
    private String email;
    private String role;
    private Boolean active;

    public UserAccount() {}

    public UserAccount(Long id, String email, String role, Boolean active) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public Boolean getActive() { return active; }
}
