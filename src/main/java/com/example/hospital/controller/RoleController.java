package com.example.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospital.service.RoleService;

@Controller
public class RoleController {
	
	private final RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping(value = "/roles")
	public String getAllRoles(Model model) {
		var roles = roleService.getAll();
		model.addAttribute("roles", roles);
		return "worker_views/roles";
	}
	
	@GetMapping("/role")
	public String getDepartmentInfo(@RequestParam(value = "roleid") Integer roleid, Model model) {
		var role = roleService.getById(roleid);
		model.addAttribute("role", role);
		return "worker_views/workers_by_role";
	}
	
}
