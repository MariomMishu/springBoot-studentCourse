package com.springboot.practice.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.practice.dto.DepartmentDto;
import com.springboot.practice.entities.Department;
import com.springboot.practice.ripository.DepartmentRepository;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentRepository repository;
	 
	@RequestMapping("/add_department")
	public String addDepartment_GET(Model model) {
		model.addAttribute("department",new DepartmentDto());
		return "department/add";
	}
	
	 @PostMapping("/save-department")
	 public String saveDepartment_POST(Model model, @ModelAttribute DepartmentDto departmentDto) {		 
		 Department department = new Department();
	        BeanUtils.copyProperties(departmentDto, department);
	        repository.save(department);
	        return "redirect:/showAll_department";
	    }
	 @RequestMapping("/showAll_department")
	 public String getAllDepartment(Model model){
	        List<Department> departmentList=repository.findAll();
	        model.addAttribute("departmentList",departmentList);
	        return "department/show-all";
	    }
	 @RequestMapping("/department/edit/{id}")
	 public String editDepartment_GET(@PathVariable Long id,Model model) {
		 Optional <Department> depOptional = repository.findById(id);
		 if(depOptional.isEmpty()) {
			 throw new RuntimeException("Department Not found With This id");
		 }
		 Department department = depOptional.get();
		 DepartmentDto departmentDto = new DepartmentDto();
		 BeanUtils.copyProperties(department, departmentDto);
		 model.addAttribute("department",departmentDto);
		 return "department/add";
		}
		
		 @PostMapping("/department/update")
		 public String editDesignation_post(Model model, @ModelAttribute DepartmentDto departmentDto) {		
		        Optional <Department> depOptional =repository.findById(departmentDto.getId());
		        Department department = depOptional.get();
				 if(department == null) {
					 department = new Department();
				 }	
		        BeanUtils.copyProperties(departmentDto, department);
		        repository.save(department);
		        return "redirect:/";
		 }
	}
