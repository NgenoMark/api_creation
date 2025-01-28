package org.example.api_creation.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "apicrt")
@IdClass(UserId.class)
public class User {

    @Id
    @Column(name = "USER_ID", nullable = false)
    private Integer id;

    @Id
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "USERNAME", nullable = false, length = 50)
    private String username;

    @Column(name = "PASSWORD_HASH", nullable = false)
    private String passwordHash;

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Lob
    @Column(name = "GENDER")
    private String gender;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY", length = 100)
    private String city;

    @Column(name = "STATE", length = 100)
    private String state;

    @Column(name = "COUNTRY", length = 100)
    private String country;

    @Column(name = "ZIP_CODE", length = 20)
    private String zipCode;

    @Lob
    @Column(name = "ROLE")
    private String role;

    @Lob
    @Column(name = "STATUS")
    private String status;

    @Column(name = "PROFILE_PICTURE")
    private byte[] profilePicture;

    @Column(name = "CREATED_AT")
    private Instant createdAt;

    @Column(name = "UPDATED_AT")
    private Instant updatedAt;

    @Column(name = "LAST_LOGIN")
    private Instant lastLogin;
}
