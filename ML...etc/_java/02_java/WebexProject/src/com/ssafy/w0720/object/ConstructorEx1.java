package com.ssafy.w0720.object;



public class ConstructorEx1 {
	public ConstructorEx1 () {
		System.out.println("씹년아1");
	}
	public ConstructorEx1 (String str) {
		this();
		System.out.println(str +" 씹년아 2");
	}
	public ConstructorEx1 (String str, int num) {
		this();
		System.out.println(str +" 씹년아3" + num);
	}
	public static void main(String[] args) {
		ConstructorEx1 ob1 = new ConstructorEx1();
		ConstructorEx1 ob2 = new ConstructorEx1("오지훈");
		ConstructorEx1 ob3 = new ConstructorEx1("오지훈",18);
	}
}
