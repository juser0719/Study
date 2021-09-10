package com.ssafy.jdbctest;

public class UserDto {
	private String id;
	private String pass;
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pass=" + pass + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
