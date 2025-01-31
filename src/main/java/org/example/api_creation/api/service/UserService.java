package org.example.api_creation.api.service;

import org.example.api_creation.api.dto.UserRequest;
import org.example.api_creation.api.dto.UserResponse;
import org.example.api_creation.api.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface  UserService {

    UserResponse fetchUser (UserRequest userRequest)
        throws Exception;

    List<Map<String ,Object>> getUsers();

    UserResponse insertUser( UserRequest userRequest)
        throws Exception;

    Optional<User> searchUserByEmail(String userRequest)
        throws Exception;
}
