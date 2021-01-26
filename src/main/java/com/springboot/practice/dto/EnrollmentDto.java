package com.springboot.practice.dto;

import java.io.Serializable;
import java.util.List;

import com.springboot.practice.entities.Course;
import com.springboot.practice.entities.Department;
import com.springboot.practice.entities.SessionTrimester;
import com.springboot.practice.entities.Student;

public class EnrollmentDto implements Serializable {
	
	private long id;
	private Department department;
	private Student student;
	private SessionTrimester sessionTrimester;
	private List<Course> courses;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public SessionTrimester getSessionTrimester() {
		return sessionTrimester;
	}
	public void setSessionTrimester(SessionTrimester sessionTrimester) {
		this.sessionTrimester = sessionTrimester;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
