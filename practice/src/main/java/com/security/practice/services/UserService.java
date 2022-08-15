package com.security.practice.services;

import com.security.practice.models.User;
import com.security.practice.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User getUserById(int userId) {
        return userRepo.findById(userId);
    }
}
