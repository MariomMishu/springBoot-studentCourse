package com.springboot.practice.request_models;

import java.io.Serializable;

public class BatchRm implements Serializable {
	
	private Long id;
	private String name;
	private Long trimesterId;
	private String trimesterCode;
	private String trimesterName;
	
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

	public String getTrimesterName() {
		return trimesterName;
	}
	public void setTrimesterName(String trimesterName) {
		this.trimesterName = trimesterName;
	}
	public Long getTrimesterId() {
		return trimesterId;
	}
	public void setTrimesterId(Long trimesterId) {
		this.trimesterId = trimesterId;
	}
	public String getTrimesterCode() {
		return trimesterCode;
	}
	public void setTrimesterCode(String trimesterCode) {
		this.trimesterCode = trimesterCode;
	}
	
	
}
