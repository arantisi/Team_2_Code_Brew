package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;



@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User getUserById(int userId) {
        return userRepo.findById(userId);
    }

    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
