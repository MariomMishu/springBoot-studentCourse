package com.springboot.practice.request_models;
  
  import java.io.Serializable; 
  import java.util.HashSet;
import java.util.List;
import java.util.Set;
  
  public class StudentRm implements Serializable { 
	  private long id; 
	  private String name; 
	  private int age; 
	  private String gender; 
	  private String email;
	  private Long departmentId;
	  private String departmentName;
	  private Long batchId;
	  private String batchName;
	  private Boolean isDelete;
	  
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
		public Long getBatchId() {
			return batchId;
		}
		public void setBatchId(Long batchId) {
			this.batchId = batchId;
		}
		public String getBatchName() {
			return batchName;
		}
		public void setBatchName(String batchName) {
			this.batchName = batchName;
		}
		
  }
 