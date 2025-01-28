package org.example.api_creation.api.model.repositories;

import org.example.api_creation.api.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
