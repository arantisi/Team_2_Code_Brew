package com.example.demo.services;

import com.example.demo.models.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService implements AuthenticationProvider {
    //    private UserRepository userRepository;
    private UserService userService;
//    private HashService hashService;

    public AuthenticationService(UserService userService) {
        this.userService = userService;
//        this.hashService = hashService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("LOOK I'm here");
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userService.getUserByUsername(username);
        if (user != null) {
//            String encodedSalt = user.getSalt();
//            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            if (user.getPassword().equals(password)) {
                System.out.println("everything worked out fine");
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
