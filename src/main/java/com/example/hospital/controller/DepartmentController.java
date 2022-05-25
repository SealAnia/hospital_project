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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.hospital.dto.DepartmentDto;
import com.example.hospital.model.entity.Department;
import com.example.hospital.service.DepartmentService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	//READ
	@GetMapping("/departments")
	public String getAllDepartments(Model model) {
		var departments = departmentService.getAll();
		model.addAttribute("departments", departments);
		return "department_views/departments";
	}
	
	@GetMapping("/departments/{id}")
	public String departmentDetails(@PathVariable Integer id, Model model) {
		List<Department> departments = new ArrayList<Department>();
		Department department = departmentService.getById(id);
		departments.add(department);
		model.addAttribute("departments", departments);
		return "department_views/departments";
	}
	
	@GetMapping("/departments/byname/{name}")
	public String departmentByName(@PathVariable String name, Model model) {
		List<Department> departments = new ArrayList<>();
		departments = departmentService.getDepartmentByName(name);
		model.addAttribute("departments", departments);
		return "department_views/departments";
	}
	
	//@GetMapping("/department")
	//public String getDepartmentInfo(@RequestParam(value = "id") Integer deptId, Model model) {
		//var department = departmentService.getById(deptId);
		//model.addAttribute("department", department);
		//return "department_views/department_details";
	//}
	
	//CREATE
	@GetMapping(value="/showdepartmentform")
	public String showCreateDepartment(Model model) {
		model.addAttribute("department", new DepartmentDto());
	    return "department_views/create_department";
	}
	
	@PostMapping(value="/departments")
	public String addDepartment
	(@ModelAttribute("department") DepartmentDto departmentDto, Model model) {
		var department = new Department();
		department.setName(departmentDto.getName());
		departmentService.createOrUpdate(department);
		var departments = departmentService.getAll();
		model.addAttribute("departments", departments);
		return "department_views/departments";
	}

	//UPDATE
	@GetMapping(value="/showeditform/{id}")
	public String showEditDepartment(@PathVariable("id") Integer id, Model model) {
		var department = departmentService.getById(id);
		model.addAttribute("department", new DepartmentDto());
	    return "department_views/edit_department";
	}
	
	@PostMapping(value = "/departments/{id}")
	public String editDept
	(@PathVariable("id") Integer id, @RequestBody Department newDepartment,
			DepartmentDto departmentDto, Model model) {
		var department = departmentService.getById(id);
		department.setId(departmentDto.getId());
		department.setName(departmentDto.getName());
		departmentService.createOrUpdate(department);
		var departments = departmentService.getAll();
		model.addAttribute("departments", departments);
		return "department_views/departments";
	}
	
	//DELETE
	@RequestMapping(value = "/deletedepartment/{id}", method = RequestMethod.GET)
	public String deleteDept(@PathVariable("id") Integer id) {
		 var department = departmentService.getById(id);
		 departmentService.delete(department.getId());
		 return "department_views/delete_department";
	}
	
}
