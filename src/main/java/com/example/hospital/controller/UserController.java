package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hospital.dto.DepartmentDto;
import com.example.hospital.dto.RoleDto;
import com.example.hospital.dto.UserDto;
import com.example.hospital.model.entity.Department;
import com.example.hospital.model.entity.Role;
import com.example.hospital.model.entity.User;
import com.example.hospital.model.repository.UserRepository;
import com.example.hospital.service.DepartmentService;
import com.example.hospital.service.RoleService;
import com.example.hospital.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	private final DepartmentService departmentService;
	private final RoleService roleService;
	private final UserRepository userRepository;
	
	@Autowired
	public UserController(UserService userService, DepartmentService departmentService, 
			RoleService roleService, UserRepository userRepository) {
		this.userService = userService;
		this.departmentService = departmentService;
		this.roleService = roleService;
		this.userRepository = userRepository;
	}
	
	//READ
	@GetMapping(value = "/workers/page{number}")
	public String getAllUsers(@PathVariable Integer number, Model model) {
		Page<User> users = userRepository.findAll(PageRequest.of(number - 1, 5));
		model.addAttribute("users", users.getContent());
		return "worker/workers";
	}
	
	@GetMapping(value = "/workers/{userid}")
	public String userDetails(@PathVariable Integer userid, Model model) {
		List<User> users = new ArrayList<User>();
		User user = userService.getById(userid);
		users.add(user);
		model.addAttribute("users", users);
		return "worker/workers";
	}
	
	@GetMapping(value = "/workers/byname/{name}")
	public String workerByName(@PathVariable String name, Model model) {
		var workers = userService.getUserByName(name);
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	@GetMapping(value = "/workers/bysurname/{surname}")
	public String workerBySurname(@PathVariable String surname, Model model) {
		var workers = userService.getUserBySurname(surname);
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	@GetMapping(value = "/worker")
	public String getPatientInfo(@RequestParam(value = "userid") Integer userid, 
			//@ModelAttribute("patient") PatientDto patientDto,
			Model model) {
		var worker = userService.getById(userid);
		model.addAttribute("user", worker);
		return "worker/worker_info";
	}
	
	//CREATE
	@GetMapping(value="/showworkerform")
	public String showCreateWorker(Model model) {
		model.addAttribute("worker", new UserDto());
		var roles = roleService.getAll();
		model.addAttribute("roles", roles);
		var departments = departmentService.getAll();
		model.addAttribute("departments", departments);
		return "worker/add_new_worker";	
	}
	
	@PostMapping(value="/workers/page1")
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
		return "worker/workers";
	}
	
	//UPDATE
	@GetMapping(value="/showeditworker/{userid}")
	public String showEditWorker(@PathVariable("userid") Integer userid, 
			@ModelAttribute(name = "newWorker") User newWorker, Model model) {
		var worker = userService.getById(userid);
		model.addAttribute("worker", worker);
		var workers = userService.getAll();
		model.addAttribute("workers", workers);
		return "worker/edit_worker";
	}
	
	@PostMapping(value = "edit_worker")
	public String editWorker(@ModelAttribute ("worker") UserDto workerDto, 
			@ModelAttribute("department") DepartmentDto departmentDto, 
			@RequestParam(value = "departmentid") Integer departmentid, 
			@ModelAttribute("role") RoleDto roleDto, 
			@RequestParam(value = "roleid") Integer roleid, Model model) {
		var worker = userService.getById(workerDto.getUserid());
		if (workerDto.getName().length() <= 0) {
			worker.setName(worker.getName());
		} else worker.setName(workerDto.getName());
		if(workerDto.getSurname().length() <= 0) {
			worker.setSurname(worker.getSurname());
		} else worker.setSurname(workerDto.getSurname());
		if(workerDto.getLogin().length() <= 0) {
			worker.setLogin(worker.getLogin());
		} else worker.setLogin(workerDto.getLogin());
		if(workerDto.getPassword().length() <= 0) {
			worker.setPassword(worker.getPassword());
		} else worker.setPassword(workerDto.getPassword());
		
		var department = departmentService.getById(departmentid);
		worker.setDept(department);
		
		var role = roleService.getById(roleid);
		worker.setRole(role);
		userService.createOrUpdate(worker);
		
		var workers = userService.getAll();
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	//DELETE
	@GetMapping(value = "/deleteworkerinfo/{userid}")
	public String deleteWorkerInfo(@PathVariable("userid") Integer iserid) {
		var worker = userService.getById(iserid);
		userService.delete(worker);
		return "worker/delete_worker";
	}
	
	//SORT
	@GetMapping(value = "/workers/sortedby/surname/asc")
	public String sortUsersBySurnameAsc(Model model) {
		var workers = userRepository.findAll(Sort.by(Direction.ASC, "surname"));
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	@GetMapping(value = "/workers/sortedby/surname/desc")
	public String sortUsersBySurnameDesc(Model model) {
		var workers = userRepository.findAll(Sort.by(Direction.DESC, "surname"));
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	@GetMapping(value = "/workers/sortedby/name/asc")
	public String sortUsersByNameAsc(Model model) {
		var workers = userRepository.findAll(Sort.by(Direction.ASC, "name"));
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	@GetMapping(value = "/workers/sortedby/name/desc")
	public String sortUsersByNameDesc(Model model) {
		var workers = userRepository.findAll(Sort.by(Direction.DESC, "name"));
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	@GetMapping(value = "/workers/sortedby/role/asc")
	public String sortUsersByRoleAsc(Model model) {
		var workers = userRepository.findAll(Sort.by(Direction.ASC, "role.name"));
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	@GetMapping(value = "/workers/sortedby/role/desc")
	public String sortUsersByRoleDesc(Model model) {
		var workers = userRepository.findAll(Sort.by(Direction.DESC, "role.name"));
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	@GetMapping(value = "/workers/sortedby/department/asc")
	public String sortUsersByDepartmentAsc(Model model) {
		var workers = userRepository.findAll(Sort.by(Direction.ASC, "dept.name"));
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	@GetMapping(value = "/workers/sortedby/department/desc")
	public String sortUsersByDepartmentDesc(Model model) {
		var workers = userRepository.findAll(Sort.by(Direction.DESC, "dept.name"));
		model.addAttribute("users", workers);
		return "worker/workers";
	}
	
	//SEARCH
	@GetMapping(value = "/workers/searchresults")
	public String searchWorkerInfo(@RequestParam String keyword, Model model) {
		var results = userService.search(keyword);
		model.addAttribute("results", results);
		return "worker/searchresults";
	}
	
}
