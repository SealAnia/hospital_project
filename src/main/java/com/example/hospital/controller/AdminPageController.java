package com.example.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {
	
	@GetMapping(value = "/adminpage")
	public String mainPage() {
		return "adminpage";
	}

}
