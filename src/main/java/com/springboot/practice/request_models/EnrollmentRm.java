package com.springboot.practice.request_models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnrollmentRm implements Serializable {
	
	private long id;
	private Long departmentId;
	private String departmentName;
	private Long studentId;
	private String studentName;
	private Long trimesterId;
	private String trimesterName;
	private List<String> courseCodes;
	private Set<Long> courseIds = new HashSet<>(); 
	private Set<String> courseNames = new HashSet<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	public List<String> getCourseCodes() {
		return courseCodes;
	}
	public void setCourseCodes(List<String> courseCodes) {
		this.courseCodes = courseCodes;
	}
	public Set<Long> getCourseIds() {
		return courseIds;
	}
	public void setCourseIds(Set<Long> courseIds) {
		this.courseIds = courseIds;
	}
	public Set<String> getCourseNames() {
		return courseNames;
	}
	public void setCourseNames(Set<String> courseNames) {
		this.courseNames = courseNames;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	
}
