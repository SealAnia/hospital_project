package com.example.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessExceptionController {
	
	@GetMapping("/not_enough_authorities")
	public String accessDenied() {
		return "exception/not_enough_authorities";
	}

}
