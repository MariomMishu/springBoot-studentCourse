package com.springboot.practice.dto;
import java.io.Serializable;
import java.util.Set;
import com.springboot.practice.entities.Enrollment;
import com.springboot.practice.entities.Trimester;
public class SessionTrimesterDto implements Serializable {
	private long id;
	
	private String name;
	
	private String code;

	private Trimester trimester;
	
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

	public Trimester getTrimester() {
		return trimester;
	}

	public void setTrimester(Trimester trimester) {
		this.trimester = trimester;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
}
