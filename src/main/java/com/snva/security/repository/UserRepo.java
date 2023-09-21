package com.snva.security.repository;

import com.snva.security.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
