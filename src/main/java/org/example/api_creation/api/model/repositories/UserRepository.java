package org.example.api_creation.api.model.repositories;

import org.example.api_creation.api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    //User findByUserEmail(String email);


    Optional<User> findByEmail(String email);  // Method to search user by email

    Optional<User> deleteByEmail(String email); // Delete user by email


}
