package com.springboot.practice.controllers;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.practice.dto.CourseDto;
import com.springboot.practice.entities.Course;
import com.springboot.practice.entities.Department;
import com.springboot.practice.request_models.CourseRm;
import com.springboot.practice.ripository.DepartmentRepository;
import com.springboot.practice.service.CourseService;
import com.springboot.practice.service.DepartmentService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private DepartmentService deptService;
	 
	@Autowired
	private DepartmentRepository depRepository;
	 
	@RequestMapping("/course/add")
	public String addCourse_GET(Model model) {
		model.addAttribute("course",new CourseRm());
		List<Department> departments=depRepository.findAll();
		model.addAttribute("departments",departments);
		return "course/add";
	}
	@PostMapping("/course/add")
	public String addCourse_POST(Model model, @ModelAttribute("courseRm") CourseRm courseRm) {
		LocalDateTime entry_date = LocalDateTime.now();
		System.out.println(courseRm.getDepartmentId());
		var deptId = deptService.getById(courseRm.getDepartmentId());
	//	System.out.println(deptId);
		CourseDto courseDto = new CourseDto();
		Course courseEntity = new Course();
		courseDto.setName(courseRm.getName());
		courseDto.setCode(courseRm.getCode());
		courseDto.setCredit(courseRm.getCredit());
		courseDto.setDepartment(deptId);
		BeanUtils.copyProperties(courseDto, courseEntity);
		courseEntity.setEntryDate(entry_date);
		courseEntity.setIsDelete(true);
		courseService.save(courseEntity);
		return "redirect:/course/show-all";
	}

	@GetMapping("/course/show-all")
	public String show_all(Model model) {
		model.addAttribute("course", new CourseRm());
		model.addAttribute("courseList",courseService.getAll());
		model.addAttribute("message", "Showing All Course");  
		return "course/show-all";
	}
	
	@RequestMapping("/course/edit/{id}")
	 public String editCourse_GET(@PathVariable Long id,Model model) {
		 
		 Course course = courseService.getById(id);
		 CourseRm courseRm = new CourseRm();
		// model.addAttribute("course",new CourseRm());
		 BeanUtils.copyProperties(course, courseRm);
		 List<Department> depts=deptService.getAll();
		 model.addAttribute("departments",depts);
		 model.addAttribute("course",courseRm);
			return "course/add";
		}
	
}
