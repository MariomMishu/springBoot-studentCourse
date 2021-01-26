package com.springboot.practice.controllers;
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
import com.springboot.practice.dto.StudentDto;
import com.springboot.practice.entities.Student;
import com.springboot.practice.request_models.StudentRm;
import com.springboot.practice.ripository.DepartmentRepository;
import com.springboot.practice.ripository.StudentRepository;
import com.springboot.practice.service.BatchService;
import com.springboot.practice.service.DepartmentService;
import com.springboot.practice.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DepartmentRepository depRepository;
	
	@Autowired
	private DepartmentService deptService;
	
	@Autowired
	private BatchService batchService;
	
	@GetMapping("/student/add")
	public String add_GET(Model model) {
		model.addAttribute("student", new StudentRm());
		model.addAttribute("genderList", this.genderList());
		model.addAttribute("departments",depRepository.findAll());
		model.addAttribute("batches", batchService.getAll());
		return "student/add";
	}
	 
	@PostMapping("/student/add")
	public String add(Model model, @ModelAttribute("studentRm") StudentRm studentRm) {
		Optional<Student> studentOptional = studentRepository.findById(studentRm.getId());
	      	Student student;
	        StudentDto studentDto = new StudentDto();
	        System.out.println(studentOptional.isEmpty());
			if (studentOptional.isEmpty()) {
	        	
	        	student = new Student();
	        } else {
	        	student = studentOptional.get();
	        	System.out.println(studentOptional.get());
	        }
	      
	      
	        var deptId = deptService.getById(studentRm.getDepartmentId());
	        var batchId = batchService.getById(studentRm.getBatchId());
	        studentDto.setName(studentRm.getName());
	        studentDto.setAge(studentRm.getAge());
	        studentDto.setEmail(studentRm.getEmail());
	        studentDto.setGender(studentRm.getGender());
	        studentDto.setDepartment(deptId);
	        studentDto.setBatch(batchId);
	        BeanUtils.copyProperties(studentDto, student);	        
	        student.setIsDelete(true);
		studentService.save(student);
		model.addAttribute("message", "New Student Added Successfully");
		return "redirect:/student/show-all";
	}
	
	@GetMapping("/student/show-all")
	public String show_all(Model model) {
		model.addAttribute("student_list", studentService.getAll());
		model.addAttribute("message", "Showing All Students");
		return "student/show-all";
	}
	@GetMapping("/student/edit/{id}")
	public String edit_GET(@PathVariable(name = "id") long id,Model model) {
		StudentRm studentRm = new StudentRm();
		Student student = studentService.getById(id);
		
		BeanUtils.copyProperties(student, studentRm);
		model.addAttribute("student", studentRm);
		model.addAttribute("genderList", this.genderList());
		model.addAttribute("departments",depRepository.findAll());
		model.addAttribute("batches", batchService.getAll());
		return "student/add";
	}
	 private List<String> genderList() {
	        List<String> genderList = new ArrayList<>();
	        genderList.add("Male");
	        genderList.add("Female");
	        return genderList;
	    }
}