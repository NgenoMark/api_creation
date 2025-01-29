package org.example.api_creation.api.service.impl;

import org.example.api_creation.api.dto.UserRequest;
import org.example.api_creation.api.dto.UserResponse;
import org.example.api_creation.api.model.User;
import org.example.api_creation.api.model.UserId;
import org.example.api_creation.api.model.repositories.UserRepository;
import org.example.api_creation.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserResponse fetchUser(UserRequest userRequest) throws Exception {
        // Query the database for a user based on the userRequest's email
        User user = userRepository.findByEmail(userRequest.getEmail());

        if (user == null) {
            throw new Exception("User not found with email: " + userRequest.getEmail());
        }

        // Create and return the response with the user's details
        return new UserResponse(
                user.getUserId().getId(), // USER_ID
                user.getUsername(),       // USERNAME
                user.getUserId().getEmail(), // EMAIL
                user.getRole()            // ROLE
        );
        //return new UserResponse(user.getUserId().getId(), user.getUsername(), user.getUserId().getEmail(), user.getRole());
    }




    @Override
    public List<Map<String, Object>> getUsers(){
        String query = "SELECT  * FROM users";

        List<Map<String, Object>> users = jdbcTemplate.queryForList(query);

        return users;
    }


    @Override
    public UserResponse insertUser(UserRequest userRequest) throws Exception {
        Integer userId = generateNewUserId();

        // Check if user already exists
        if (userRepository.existsById(new UserId(userId, userRequest.getEmail()))) {
            throw new Exception("User already exists with email: " + userRequest.getEmail());
        }

        // Create and save user
        User newUser = new User();
        newUser.setUserId(new UserId(userId, userRequest.getEmail()));

        newUser.setUsername(userRequest.getUsername());
        newUser.setPasswordHash(hashPassword(userRequest.getPasswordHash()));
        newUser.setFirstName(userRequest.getFirstName());
        newUser.setLastName(userRequest.getLastName());
        newUser.setRole(userRequest.getRole());
        newUser.setStatus("ACTIVE");
        newUser.setCreatedAt(Instant.now());
        newUser.setUpdatedAt(Instant.now());

        userRepository.save(newUser);

        // Return the UserResponse with data from the new user
        return new UserResponse(
                newUser.getUserId().getId(), // USER_ID
                newUser.getUsername(),       // USERNAME
                newUser.getUserId().getEmail(), // EMAIL
                newUser.getRole()            // ROLE
        );
        //return new UserResponse(newUser.getUserId().getId(), newUser.getUsername(), newUser.getUserId().getEmail(), newUser.getRole());

    }


    /**
     * Simulates password hashing
     */
    private String hashPassword(Object password) {
        return (String) password; // Replace with a real hashing function like BCrypt
    }

    /**
     * Generates a new user ID (For now, fetch max ID and increment)
     */
    private Integer generateNewUserId() {
        String sql = "SELECT COALESCE(MAX(USER_ID), 0) + 1 FROM users";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }


}
