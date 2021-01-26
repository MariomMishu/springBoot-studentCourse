package com.springboot.practice.entities;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
@Entity
@Table(name = "tbl_session_trimester")
public class SessionTrimester {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;

	@ManyToOne(fetch = FetchType.LAZY)
	private Trimester trimester;
	
	@Column(name = "academic_year")
	private String academicYear;

	@OneToMany(mappedBy = "sessionTrimester", cascade = CascadeType.ALL)
    private Set<Enrollment> enrollments;
	
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
	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	public Trimester getTrimester() {
		return trimester;
	}
	public void setTrimester(Trimester trimester) {
		this.trimester = trimester;
	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
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
	
	
	
}
