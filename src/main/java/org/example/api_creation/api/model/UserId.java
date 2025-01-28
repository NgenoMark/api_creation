package org.example.api_creation.api.model;

import java.io.Serializable;
import java.util.Objects;

public class UserId implements Serializable {
    private Integer id;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Default constructor
    public UserId() {}

    public UserId(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    // Getters, Setters, hashCode and equals methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return Objects.equals(id, userId.id) && Objects.equals(email, userId.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}

