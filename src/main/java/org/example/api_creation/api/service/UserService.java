package org.example.api_creation.api.service;

import org.example.api_creation.api.dto.UserRequest;
import org.example.api_creation.api.dto.UserResponse;

import java.util.List;
import java.util.Map;


public interface  UserService {

    UserResponse fetchUser (UserRequest userRequest)
        throws Exception;

    List<Map<String ,Object>> getUsers();
}
