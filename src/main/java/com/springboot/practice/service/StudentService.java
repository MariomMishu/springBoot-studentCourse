package com.springboot.practice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.springboot.practice.entities.Student;
import com.springboot.practice.ripository.StudentRepository;  
  
  @Service 
  public class StudentService { 
	  private final StudentRepository studentRepo;
  
  public StudentService(StudentRepository studentRepo) { 
	  this.studentRepo = studentRepo; 
	  }
  
	
	 public List<Student> getAll() { 
		 return studentRepo.findAllByIsDeleteTrue(); 
		 }
	 public List<Student> getAllStudents(long departmentId) { 
		 List<Student> student_list = studentRepo.findAllByDepartmentId(departmentId); 
		// System.out.println(student_list);
		 return student_list;
		 }
  
	/*
	 * public List<StudentDto> getAllDto(){ List<StudentDto> studentDtos = new
	 * ArrayList<>(); studentRepo.findAll().stream().forEach(student -> { StudentDto
	 * studentDto = new StudentDto(); BeanUtils.copyProperties(student, studentDto);
	 * studentDtos.add(studentDto); }); return studentDtos; }
	 */
  
  public Student save(Student student) { 
	  return studentRepo.save(student); 
	  }
  
  public Student getById(long studentId) { 
	  Optional<Student> optionalStudent = studentRepo.findById(studentId); 
	  if (optionalStudent.isEmpty()) { 
		  throw new RuntimeException("Student Not Find By this Id"); 
		  } else { 
			  return optionalStudent.get(); 
			  } 
	  } 
  }
  
 