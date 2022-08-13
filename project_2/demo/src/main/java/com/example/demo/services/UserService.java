package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public Optional<User> getUserById(int id) {
        return Optional.of(userRepository.findById(id).get());
    }

    public boolean isUsernameAvailable(String username) {
        return userRepository.findUserByUsername(username) == null;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}