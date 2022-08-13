package com.example.demo.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.MyUserDetails;

@Controller
@RequestMapping("")
public class UserController {

	@GetMapping("/user")
	public String user(HttpSession session, @RequestParam(defaultValue = "Guest") String u,
			@RequestParam(required = false) String p) {
		MyUserDetails details = (MyUserDetails) Optional
				.ofNullable(SecurityContextHolder.getContext().getAuthentication()).map(Authentication::getPrincipal)
				.orElse(null);

		if (details == null) {
			return "<h1>Unauthenticated</h1>";
		} else {
			return "<h1>Welcome " + details.getUsername() + "</h1>";
		}
	}

	@PostMapping("")
	public String homepage(HttpSession session, @RequestParam(defaultValue = "Guest") String u,
			@RequestParam(required = false) String p) {
		System.out.println(u);
		System.out.println(p);
		session.setAttribute("u", u);
		session.setAttribute("p", p);
		// AccountsRepo.login(u,p);

		return u;
	}
}