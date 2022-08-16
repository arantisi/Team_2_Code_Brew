package com.security.practice.controllers;

import com.security.practice.models.User;
import com.security.practice.services.CustomUserDetailsService;
import com.security.practice.models.CustomUserDetails;
import com.security.practice.controllers.UserController;
import com.security.practice.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.Collections;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.security.config.http.MatcherType.mvc;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//@WebMvcTest(UserController.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    CustomUserDetailsService userService;

    UserDetails userDetails;

     final int id = 1;

    //@WithMockUser(username = "jim",password = "pass123", roles = "user")
    @BeforeEach
    void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
        userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.singleton(new SimpleGrantedAuthority("user"));
            }

            @Override
            public String getPassword() {
                return "pass123";
            }

            @Override
            public String getUsername() {
                return "jim";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };








    }

    @Test
    //@WithMockUser(username = "jim",password = "pass123", roles = "user")
    final void testGetUser(){

        when(userService.loadUserByUsername(anyString())).thenReturn(userDetails);

        User user =userController.getUserById(id);

        assertNotNull(user);
        assertEquals(id,user.getId());
        assertEquals(userDetails.getUsername(),user.getUsername());
        assertEquals(userDetails.getPassword(),user.getPassword());

    }

}