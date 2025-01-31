package org.example.api_creation.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor// This auto-generates a constructor with all fields
public class UserResponse {
    private Integer id;
    private String username;
    private String email;
    private String role;

    // Add a constructor that accepts id, username, email, and role
//    public UserResponse(Integer id, String username, String email, String role) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.role = role;
//    }
}
