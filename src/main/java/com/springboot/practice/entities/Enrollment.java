package com.springboot.practice.entities;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_enrollment")
public class Enrollment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "session_trimester_id")
    private SessionTrimester sessionTrimester;

	@ManyToMany(targetEntity = Course.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "course_enrollment", joinColumns = @JoinColumn(name = "enrollment_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	private List<Course> courses;
	
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
