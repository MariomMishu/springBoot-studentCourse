package com.springboot.practice.request_models;
import java.io.Serializable;
import java.util.Set;
import com.springboot.practice.entities.Enrollment;

public class SessionTrimesterRm implements Serializable {
	
	private long id;
	
	private String name;
	
	private String code;

	private Long trimesterId;
	
	private String trimesterName;
	
	private String academicYear;

	private Set<Enrollment> enrollments;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getTrimesterId() {
		return trimesterId;
	}

	public void setTrimesterId(Long trimesterId) {
		this.trimesterId = trimesterId;
	}

	public String getTrimesterName() {
		return trimesterName;
	}

	public void setTrimesterName(String trimesterName) {
		this.trimesterName = trimesterName;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	
}
