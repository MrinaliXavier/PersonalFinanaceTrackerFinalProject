package com.example.personalFinanceTracker.service;

import com.example.personalFinanceTracker.Repo.UserRepository;
import com.example.personalFinanceTracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Long addUser(User user) {
        return userRepository.save(user).getId();
    }
}
