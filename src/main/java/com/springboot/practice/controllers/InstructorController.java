package com.springboot.practice.controllers;

import java.util.ArrayList;
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
import com.springboot.practice.dto.InstructorDto;
import com.springboot.practice.entities.Department;
import com.springboot.practice.entities.Instructor;
import com.springboot.practice.request_models.InstructorRm;
import com.springboot.practice.ripository.DepartmentRepository;
import com.springboot.practice.ripository.InstructorRepository;

@Controller
public class InstructorController {
	 @Autowired
	  private InstructorRepository repository;
	 
	 @Autowired
	 private DepartmentRepository depRepository;
	 
	@RequestMapping("/add_instructor")
	public String addInstructor_GET(Model model) {
		model.addAttribute("instructor",new InstructorRm());
		List<Department> departments=depRepository.findAll();
		model.addAttribute("departments",departments);
		
		List<String> employmentTypes = new ArrayList<>();
		employmentTypes.add("Full Time");
		employmentTypes.add("Part Time");
		model.addAttribute("employmentTypes",employmentTypes);
		return "instructor/add";
	}
	
	 @PostMapping("/save-instructor")
	 public String saveInstructor_post(Model model, @ModelAttribute InstructorRm instructorRm) {		
		 var departmentId = depRepository.getOne(instructorRm.getDepartmentId());
	        Instructor instructor = new Instructor();
	        InstructorDto instructorDto = new InstructorDto();
	        
	        instructorDto.setName(instructorRm.getName());
	        instructorDto.setSalary(instructorRm.getSalary());
	        instructorDto.setAddress(instructorRm.getAddress());
	        instructorDto.setAge(instructorRm.getAge());
	        instructorDto.setMobile(instructorRm.getMobile());
	        instructorDto.setEmploymentType(instructorRm.getEmploymentType());
	        instructorDto.setDepartment(departmentId);
	        BeanUtils.copyProperties(instructorDto, instructor);	        
	        instructor.setIsDelete(true);
	        repository.save(instructor);
	        return "redirect:/showAll_instructor";
	    }
	
	 @RequestMapping("/showAll_instructor")
	 public String getAllInstructor(Model model){
	        List<Instructor> instructorList=repository.findAll();
	        model.addAttribute("instructorList",instructorList);
	        return "instructor/show-all";
	    }
	 
	 @RequestMapping("/instructor/edit/{id}")
	 public String editEmployee_GET(@PathVariable Long id,Model model) {
		 Optional <Instructor> insOptional = repository.findById(id);
		 if(insOptional.isEmpty()) {
			 throw new RuntimeException("Employee Not found With This id");
		 }
		 Instructor instructor = insOptional.get();
		 InstructorRm instructorRm = new InstructorRm();
		 model.addAttribute("instructor",new InstructorRm());
		 BeanUtils.copyProperties(instructor, instructorRm);
		 List<Department> departments=depRepository.findAll();
			model.addAttribute("departments",departments);
			List<String> employmentTypes = new ArrayList<>();
			employmentTypes.add("Full Time");
			employmentTypes.add("Part Time");
			model.addAttribute("employmentTypes",employmentTypes);
			model.addAttribute("instructor",instructorRm);
			return "instructor/edit";
		}
		
		 @PostMapping("/instructor/update")
		 public String editInstructor_post(Model model, @ModelAttribute InstructorDto instructorDto) {		
		        Optional <Instructor> insOptional =repository.findById(instructorDto.getId());
				 Instructor instructor = insOptional.get();
				 if(instructor == null) {
					 instructor = new Instructor();
				 }	
		        BeanUtils.copyProperties(instructorDto, instructor);
		        repository.save(instructor);
		        return "redirect:/";
		    }
}
