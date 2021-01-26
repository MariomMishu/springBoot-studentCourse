package com.springboot.practice.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_student")
public class Student implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "email")
	private String email;
	
	@Column(name = "is_delete")
	private Boolean isDelete;
	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;
	@ManyToOne(fetch = FetchType.LAZY)
	private Batch batch;
	
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
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
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email
				+ ", isDelete=" + isDelete + ", department=" + department + ", batch=" + batch
				+ "]";
	}
	public Student(long id, String name, int age, String gender, String email,  Boolean isDelete,
			Department department, Batch batch) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;		
		this.isDelete = isDelete;
		this.department = department;
		this.batch = batch;
		
	}
	public Student() {
		super();
	}
	
	
}
