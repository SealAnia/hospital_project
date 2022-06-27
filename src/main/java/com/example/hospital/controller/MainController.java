package com.example.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hospital.service.impl.UserServiceImpl;

@Controller
public class MainController {
	
	private final UserServiceImpl userService;
	
	@Autowired
	public MainController(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/main")
	public String mainPage(Authentication authentication, String username, Model model) {
		username = authentication.getName();
		var user = userService.loadUserByUsername(username);
		model.addAttribute("user", user);
		return "main";
	}

}
