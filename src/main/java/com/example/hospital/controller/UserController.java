package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospital.dto.DepartmentDto;
import com.example.hospital.dto.RoleDto;
import com.example.hospital.dto.UserDto;
import com.example.hospital.model.entity.Department;
import com.example.hospital.model.entity.Patient;
import com.example.hospital.model.entity.Role;
import com.example.hospital.model.entity.User;
import com.example.hospital.service.DepartmentService;
import com.example.hospital.service.RoleService;
import com.example.hospital.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	private final DepartmentService departmentService;
	
	private final RoleService roleService;
	
	@Autowired
	public UserController(UserService userService, DepartmentService departmentService, RoleService roleService) {
		this.userService = userService;
		this.departmentService = departmentService;
		this.roleService = roleService;
	}
	
	//READ
	@GetMapping(value = "/workers")
	public String getAllUsers(Model model) {
		var workers = userService.getAll();
		model.addAttribute("users", workers);
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
	
	@GetMapping(value = "/workers/byname/{name}")
	public String workerByName(@PathVariable String name, Model model) {
		List<User> workers = new ArrayList<>();
		workers = userService.getUserByName(name);
		model.addAttribute("users", workers);
		return "worker_views/workers";
	}
	
	@GetMapping(value = "/workers/bysurname/{surname}")
	public String workerBySurname(@PathVariable String surname, Model model) {
		List<User> workers = new ArrayList<>();
		workers = userService.getUserBySurname(surname);
		model.addAttribute("users", workers);
		return "worker_views/workers";
	}
	
	//CREATE
	@GetMapping(value="/showworkerform")
	public String showCreateWorker(Model model) {
		model.addAttribute("worker", new UserDto());
		return "worker_views/add_new_worker";	
	}
	
	@PostMapping(value="/workers")
	public String addWorker(@RequestParam(value = "departmentid") Integer departmentid, 
			@RequestParam(value = "roleid") Integer roleid, 
			@ModelAttribute("worker") UserDto userDto,
			@ModelAttribute("department") DepartmentDto departmentDto, 
			@ModelAttribute("role") RoleDto roleDto,
			Model model) {
		var user = new User();
		user.setName(userDto.getName());
		user.setSurname(userDto.getSurname());
		user.setLogin(userDto.getLogin());
		user.setPassword(userDto.getPassword());
		
		var department = new Department();
		department = departmentService.getById(departmentid);
		user.setDept(department);
		
		var role = new Role();
		role = roleService.getById(roleid);
		user.setRole(role);
		
		userService.createOrUpdate(user);
		
		var workers = userService.getAll();
		model.addAttribute("users", workers);
		return "worker_views/workers";
	}
	
	//UPDATE
	
	//DELETE
	@RequestMapping(value = "/deleteworkerinfo/{userid}", method = RequestMethod.GET)
	public String deleteWorkerInfo(@PathVariable("userid") Integer iserid) {
		var worker = userService.getById(iserid);
		userService.delete(worker);
		return "worker_views/delete_worker";
	}
	
	//SEARCH
	@RequestMapping(value = "/workers/searchresults")
	public String searchWorkerInfo(@RequestParam String keyword, Model model) {
		List<User> results = userService.search(keyword);
		model.addAttribute("results", results);
		return "worker_views/searchresults";
	}
	
}
