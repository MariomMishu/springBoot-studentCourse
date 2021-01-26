package com.springboot.practice.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbl_instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "salary")
	private Double salary;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "employmentType")
	private String employmentType;
	
	@Column(name = "joining_date")
	private LocalDate joiningDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;
	
	@Column(name = "is_delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Instructor(Long id, String name, Double salary, String address, String mobile, Integer age,
			String employmentType, LocalDate joiningDate, Department department, Boolean isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.mobile = mobile;
		this.age = age;
		this.employmentType = employmentType;
		this.joiningDate = joiningDate;
		this.department = department;
		this.isDelete = isDelete;
	}

	public Instructor() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + ", mobile="
				+ mobile + ", age=" + age + ", employmentType=" + employmentType + ", joiningDate=" + joiningDate
				+ ", department=" + department + ", isDelete=" + isDelete + "]";
	}	
	
}
