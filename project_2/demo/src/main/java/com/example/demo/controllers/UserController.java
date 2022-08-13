package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
@RequestMapping("")
public class UserController {

    @GetMapping("/")
    public String login() {

        return "forward:html/Login.html";
    }

    @GetMapping("/user")
    public String user(HttpSession session,@RequestParam(defaultValue="Guest") String u,@RequestParam(required = false) String p) {
        return "<h1>Welcome User</h1>";
    }


    @PostMapping("")
    public String homepage(HttpSession session,@RequestParam(defaultValue="Guest") String u,@RequestParam(required = false) String p) {

        System.out.println(u);
        System.out.println(p);
        session.setAttribute("u",u);
        session.setAttribute("p",p);
        //AccountsRepo.login(u,p);

        return u;
    }
}