package org.example.api_creation.api.service.impl;

import org.example.api_creation.api.dto.UserRequest;
import org.example.api_creation.api.dto.UserResponse;
import org.example.api_creation.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public UserResponse fetchUser (UserRequest userRequest)
            throws Exception
    {
        UserResponse userResponse = new UserResponse();
        try {
        }
        catch (Exception e){
            throw e ;
    }
        return userResponse;
    }


    @Override
    public List<Map<String, Object>> getUsers(){
        String query = "Select * from users";

        List<Map<String, Object>> users = jdbcTemplate.queryForList(query);

        return users;
    }
}
