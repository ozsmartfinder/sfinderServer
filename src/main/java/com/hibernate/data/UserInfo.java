package com.hibernate.data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="UserInfo")
public class UserInfo {
	
	@javax.persistence.Id
	private int Id;
	private String Username;
	private String Password;
	private String Phone;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	

}
