package com.springboot.practice.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Table(name="tbl_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "username")
	private String username;
	@Column(name = "password", length = 512)
	private String password;
	@Column(name = "fullName")
	private String fullName;
	@Column(name = "email")
	private String email;
	@Column(name = "gender")
	private String gender;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "profile_pic")
	private String profilePic;
	@ManyToOne
	private Role role;
	@Column(name = "active_status")
	private Boolean activeStatus;
	@Column(name = "is_expired")
	private Boolean isExpired;
	@Column(name = "is_locked")
	private Boolean isLocked;
	@Column(name = "e_date")
	private LocalDateTime entryDate;
	@Column(name = "u_date")
	private LocalDateTime updateDate;
	
	
	public User() {
		this.id = UUID.randomUUID().toString();
	}
	
	public User(String id, String username, String password, String fullName, String email, String gender,
			LocalDate dob, String profilePic, Role role, Boolean activeStatus, Boolean isExpired, Boolean isLocked,
			LocalDateTime entryDate, LocalDateTime updateDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.profilePic = profilePic;
		this.role = role;
		this.activeStatus = activeStatus;
		this.isExpired = isExpired;
		this.isLocked = isLocked;
		this.entryDate = entryDate;
		this.updateDate = updateDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Boolean getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public Boolean getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(Boolean isExpired) {
		this.isExpired = isExpired;
	}
	public Boolean getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
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
