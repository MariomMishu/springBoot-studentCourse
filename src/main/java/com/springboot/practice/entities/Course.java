package com.springboot.practice.entities;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	@Column(name = "credit_hr")
	private String credit;
	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;
	@Column(name = "is_delete")
	private Boolean isDelete;
	@Column(name = "e_date")
	private LocalDateTime entryDate;
	@Column(name = "u_date")
	private LocalDateTime updateDate;
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
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
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
	public LocalDateTime getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public Course(long id, String name, String code, String credit, Department department, Boolean isDelete,
			LocalDateTime entryDate, LocalDateTime updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.credit = credit;
		this.department = department;
		this.isDelete = isDelete;
		this.entryDate = entryDate;
		this.updateDate = updateDate;
	}
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", code=" + code + ", credit=" + credit + ", department="
				+ department + ", isDelete=" + isDelete + ", entryDate=" + entryDate + ", updateDate=" + updateDate
				+ "]";
	}
	
	
}
