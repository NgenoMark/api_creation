package org.example.api_creation.api.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserId implements Serializable {

    private Integer id;
    private String email;

    // Constructors, Getters, Setters, hashCode, equals methods

    public UserId() {}

    public UserId(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return id.equals(userId.id) && email.equals(userId.email);
    }

    @Override
    public int hashCode() {
        return 31 * id.hashCode() + email.hashCode();
    }
}
