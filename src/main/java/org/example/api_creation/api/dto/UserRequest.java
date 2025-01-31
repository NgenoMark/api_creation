package org.example.api_creation.api.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String email;
    private String username;
    private String passwordHash;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String firstName;
    private String lastName;
    private String role;
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public Object getPasswordHash() {
        return passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }
}
