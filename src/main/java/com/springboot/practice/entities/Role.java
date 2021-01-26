package com.springboot.practice.entities;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_role")
public class Role {
	@Id
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "authority")
	private String authority;
	
	public Role() {
		this.id = UUID.randomUUID().toString();
	}
	public Role(String authority) {
		this.id = UUID.randomUUID().toString();
		this.authority = authority;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
