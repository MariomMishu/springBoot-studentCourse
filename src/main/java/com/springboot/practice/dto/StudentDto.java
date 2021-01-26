package com.springboot.practice.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.springboot.practice.entities.Batch;
import com.springboot.practice.entities.Course;
import com.springboot.practice.entities.Department;

public class StudentDto implements Serializable {
	private long id;
	private String name;
	private int age;
	private String gender;
	private String email;
	private Boolean isDelete;
	private Department department;
	private Batch batch;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
}
