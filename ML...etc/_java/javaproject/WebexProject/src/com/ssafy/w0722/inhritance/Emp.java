package com.ssafy.w0722.inhritance;

public class Emp {
	private String name;
	private String phone;
	
	public Emp(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public Emp() {
		super();
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", phone=" + phone + "]";
	}
	
}
