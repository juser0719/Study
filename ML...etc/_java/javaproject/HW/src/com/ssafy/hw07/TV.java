package com.ssafy.hw07;

public class TV extends Product{
	
	private int inch;
	public TV() {
			
		}

	public TV(String name, int number, int price, int total ,int inch) {
		super(name,number,price,total);
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}
	
	
}
