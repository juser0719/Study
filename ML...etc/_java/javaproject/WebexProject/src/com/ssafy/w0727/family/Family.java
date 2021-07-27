package com.ssafy.w0727.family;

public class Family {
	private String name;

	public Family() {
		super();
	}

	public Family(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\n";
	}
}
