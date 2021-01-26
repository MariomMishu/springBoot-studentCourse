package com.springboot.practice.dto;
import java.io.Serializable;
import lombok.Data;

@Data
public class DepartmentDto implements Serializable{
	
	private Long id;
	private String name;
	
	public DepartmentDto() {
		super();
	}
	public DepartmentDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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
	
	
}
