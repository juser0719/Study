package com.ssafy.hw07;

public class Refrigerator extends Product{
	
	private int L;
	
	public Refrigerator() {
		
	}

	public Refrigerator(String name, int number, int price, int total, int l) {
		super(name,number,price,total);
		this.L = l;
	}

	public int getL() {
		return L;
	}
	
}
