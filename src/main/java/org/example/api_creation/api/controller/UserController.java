package org.example.api_creation.api.controller;


import org.example.api_creation.api.dto.UserRequest;
import org.example.api_creation.api.model.User;
import org.example.api_creation.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {


    @Autowired
    private UserService userService;
    private org.example.api_creation.api.dto.UserRequest UserRequest;


    @RequestMapping(path = "/userLogin")
    public Object fetchUser(UserRequest userRequest)
            throws Exception {
        return userService.fetchUser(userRequest);
    }

    @GetMapping(path = "/getUsers")
    public List<Map<String, Object>> getUsers() {
    return userService.getUsers();
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> insertUser(@RequestBody User user) {
        try {
            userService.insertUser( UserRequest );
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating user: " + e.getMessage());
        }
    }


    // Search User method
    @GetMapping("/searchUser")
    public ResponseEntity<Object> searchUser(@RequestParam String email) {
        try {
            Optional<User> user = userService.searchUserByEmail(email); // Searching by email, adjust if necessary
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());  // Return the found user details
            } else {
                return ResponseEntity.status(404).body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error searching user: " + e.getMessage());
        }
    }

}
