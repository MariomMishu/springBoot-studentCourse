package com.springboot.practice.dto;

import java.io.Serializable;

import com.springboot.practice.entities.SessionTrimester;
public class BatchDto implements Serializable {
	
	private Long id;
	private String name;
	private SessionTrimester trimester;
	
	public BatchDto() {
		super();
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

	public SessionTrimester getTrimester() {
		return trimester;
	}

	public void setTrimester(SessionTrimester trimester) {
		this.trimester = trimester;
	}
	
	
}
