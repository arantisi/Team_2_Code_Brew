package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
@RequestMapping("")
public class LoginController {

    @GetMapping("")
    public String login() {
        return "forward:html/Login.html";
    }

    @PostMapping("")
    public String homepage(@RequestParam(defaultValue="Guest") String u,@RequestParam(required = false) String p) {

        System.out.println(u);
        System.out.println(p);
       /* HttpSession session=req.getSession();
        session.setAttribute("u",u);
        session.setAttribute("p",p);
        login(resp,u,p);*/

        return "hi";
    }
}
