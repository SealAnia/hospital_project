package com.example.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.hospital.model.entity.Department;
import com.example.hospital.model.repository.DepartmentRepository;
import com.example.hospital.service.DepartmentService;

@Controller
public class DepartmentController {
	
	private final DepartmentService departmentService;
	private final DepartmentRepository departmentRepository;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService, DepartmentRepository departmentRepository) {
		this.departmentService = departmentService;
		this.departmentRepository = departmentRepository;
	}
	
	//READ
	@GetMapping("/departments")
	public String getAllDepartments(Model model) {
		var departments = departmentService.getAll();
		model.addAttribute("departments", departments);
		return "department/departments";
	}
	
	@GetMapping("/departments/{id}")
	public String departmentDetails(@PathVariable Integer id, Model model) {
		List<Department> departments = new ArrayList<Department>();
		Department department = departmentService.getById(id);
		departments.add(department);
		model.addAttribute("departments", departments);
		return "department/departments";
	}
	
	@GetMapping("/departments/byname/{name}")
	public String departmentByName(@PathVariable String name, Model model) {
		var departments = departmentService.getDepartmentByName(name);
		model.addAttribute("departments", departments);
		return "department/departments";
	}

	@GetMapping("/department")
	public String getDepartmentInfo(@RequestParam(value = "id") Integer id, Model model) {
		var department = departmentService.getById(id);
		model.addAttribute("department", department);
		return "department/department_details";
	}
	
	//SORT
	@GetMapping("/departments/sortedby/name/asc")
	public String sortDepartmentsByNameAsc(Model model) {
		var departments = departmentRepository.findAll(Sort.by(Direction.ASC, "name"));
		model.addAttribute("departments", departments);
		return "department/departments";
	}
	
	@GetMapping("/departments/sortedby/name/desc")
	public String sortDepartmentsByNameDesc(Model model) {
		var departments = departmentRepository.findAll(Sort.by(Direction.DESC, "name"));
		model.addAttribute("departments", departments);
		return "department/departments";
	}
	
	//CREATE
	@GetMapping(value="/showdepartmentform")
	public String showCreateDepartment(Model model) {
		model.addAttribute("department", new DepartmentDto());
	    return "department/create_department";
	}
	
	@PostMapping(value="/departments")
	public String addDepartment
	(@ModelAttribute("department") DepartmentDto departmentDto, Model model) {
		var department = new Department();
		department.setName(departmentDto.getName());
		departmentService.createOrUpdate(department);
		var departments = departmentService.getAll();
		model.addAttribute("departments", departments);
		return "department/departments";
	}
	
	//UPDATE
	@GetMapping(value="/showeditdepartment/{id}")
	public String showEditDepartment(@PathVariable("id") Integer id, 
			@ModelAttribute(name = "newDepartment") Department newDepartment,
			Model model) {
		var department = departmentService.getById(id);
		model.addAttribute("department", department);
	    return "department/edit_department";
	}
	
	@PostMapping(value="/editdepartment")
	public String editDepartment(@ModelAttribute("department") DepartmentDto departmentDto, Model model) {
		var department = departmentService.getById(departmentDto.getId());
		
		if(departmentDto.getName().length() <= 0) {
			department.setName(department.getName());
		} else {
			department.setName(departmentDto.getName()); 
		}
		
		departmentService.createOrUpdate(department);
		var departments = departmentService.getAll();
		model.addAttribute("departments", departments);
		return "department/departments";
	}
	
	//DELETE
	@GetMapping(value = "/deletedepartment/{id}")
	public String deleteDept(@PathVariable("id") Integer id) {
		 var department = departmentService.getById(id);
		 departmentService.delete(department);
		 return "department/delete_department";
	}
	
	//SEARCH
	@GetMapping(value = "/departments/searchresults")
	public String searchDepartmentInfo(@RequestParam String keyword, Model model) {
		var results = departmentService.search(keyword);
		model.addAttribute("results", results);
		return "department/searchresults";
	}
	
}
