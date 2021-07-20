package com.ssafy.w0714.basic;

//Integer.parseInt("문자열") --> 정수
//주의)문자열은 모두 숫자로 구성되어있어야 함
public class Ex06_ParseInt {
	public static void main(String[] args) {
		String a="100";
		String b="200";
		
		int x=Integer.parseInt(a); // "100" --> 100
		int y=Integer.parseInt(b);
		
		System.out.println(a+b);   // 100200
		System.out.println(x+y);   // 300
	}
}
/*
100200
300
*/