package org.example.api_creation.api.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String email;
    private String username;
    private String passwordHash;
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
