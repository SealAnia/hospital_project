package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.hospital.model.entity.User;
import com.example.hospital.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//READ
	@GetMapping(value = "/workers")
	public String getAllUsers(Model model) {
		var workers = userService.getAll();
		model.addAttribute("workers", workers);
		return "worker_views/workers";
	}
	
	@GetMapping(value = "/workers/{userid}")
	public String userDetails(@PathVariable Integer userid, Model model) {
		List<User> users = new ArrayList<User>();
		User user = userService.getById(userid);
		users.add(user);
		model.addAttribute("users", users);
		return "worker_views/workers";
	}

}
