package com.ssafy.w0728.lambda;

@FunctionalInterface
interface Function {
	public double calc(int a , int b);
	default public void view() {
		System.out.println("view1 method");
	}
	
}

public class LambdaEx6 {

	
	public static void main(String[] args) {
		Function m1 = (a,b) -> a+b;
		Function m2 = (a,b) -> a-b;
		
		m1.view();
		System.out.println(m1.calc(5, 0));
		
	}
}
