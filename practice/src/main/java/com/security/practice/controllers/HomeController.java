package com.security.practice.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class HomeController {

    @GetMapping("/user")
    public String home(){
        return "This is user Home Page";
    }

    @GetMapping("/")
    public String homeLogin(){
        return "redirect:index.html";
    }

    @GetMapping("/login")
    public String home3(){
        return "This is user Home Page";
    }

    /*@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }*/

    @GetMapping("/admin")
    public String admin(){
        return "This is Admin Page";
    }

    @GetMapping("/home")
    public String home2(){
        return "This is logout works";
    }
}
