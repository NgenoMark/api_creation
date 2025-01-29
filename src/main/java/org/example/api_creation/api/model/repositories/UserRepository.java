package org.example.api_creation.api.model.repositories;

import org.example.api_creation.api.model.User;
import org.example.api_creation.api.model.UserId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, UserId> {

    boolean existsById(UserId userId);

    User findByEmail(String email); // Find a user by email
}
