package com.ssafy.w0728.lambda;

interface Calc {
	public double calc(int a , int b);
	
}

public class LambdaEx5 {

	
	public static void main(String[] args) {
		Calc m1 = (a,b) -> a+b;
		Calc m2 = (a,b) -> a-b;
		Calc m3 = (a,b) -> a*b;
		Calc m4 = (a,b) -> a/b;
		
		System.out.println(m1.calc(2, 5));
		System.out.println(m2.calc(2, 5));
		System.out.println(m3.calc(2, 5));
		System.out.println(m4.calc(2, 5));
		
	}
}
