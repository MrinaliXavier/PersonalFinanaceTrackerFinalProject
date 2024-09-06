package com.example.personalFinanceTracker.Repo;

import com.example.personalFinanceTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    // Method to find a user by email
    Optional<User> findByEmail(String email);
}

