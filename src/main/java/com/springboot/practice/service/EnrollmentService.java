package com.springboot.practice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.springboot.practice.entities.Enrollment;
import com.springboot.practice.entities.Student;
import com.springboot.practice.ripository.EnrollmentRepository;
import com.springboot.practice.ripository.StudentRepository;

  
  
  @Service 
  public class EnrollmentService { 
	  private final EnrollmentRepository enrollRepo;
	  private final StudentRepository studentRepo;
  
  public EnrollmentService(EnrollmentRepository enrollRepo,StudentRepository studentRepo) { 
	  this.enrollRepo = enrollRepo; 
	  this.studentRepo = studentRepo; 
	  }
  
	
	 public List<Enrollment> getAll() { 
		 return enrollRepo.findAllByIsDeleteTrue(); 
		 }
	 
  
	/*
	 * public List<StudentDto> getAllDto(){ List<StudentDto> studentDtos = new
	 * ArrayList<>(); studentRepo.findAll().stream().forEach(student -> { StudentDto
	 * studentDto = new StudentDto(); BeanUtils.copyProperties(student, studentDto);
	 * studentDtos.add(studentDto); }); return studentDtos; }
	 */
  
  public Enrollment save(Enrollment enrollment) { 
	  return enrollRepo.save(enrollment); 
	  }
  
	/*
	 * public Student getById(long studentId) { Optional<Student> optionalStudent =
	 * studentRepo.findById(studentId); if (optionalStudent.isEmpty()) { throw new
	 * RuntimeException("Student Not Find By this Id"); } else { return
	 * optionalStudent.get(); } }
	 */
  public Enrollment getById(long id) { 
	  Optional<Enrollment> optionalEnrollment = enrollRepo.findById(id); 
	  if (optionalEnrollment.isEmpty()) { 
		  throw new RuntimeException("Enrollment Not Find By this Id"); 
		  } else { 
			  return optionalEnrollment.get(); 
			} 
	  } 
  }
  
 