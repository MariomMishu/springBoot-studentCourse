package com.springboot.practice.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_batch")
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	private SessionTrimester trimester;
	
	@Column(name = "name")
	private String name;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@Column(name = "e_date")
	private LocalDateTime entryDate;
	
	@Column(name = "u_date")
	private LocalDateTime updateDate;
	
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

	public SessionTrimester getTrimester() {
		return trimester;
	}

	public void setTrimester(SessionTrimester trimester) {
		this.trimester = trimester;
	}
	
	
	
}
