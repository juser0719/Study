package com.ssafy.w0728.lambda;
@FunctionalInterface
interface Ver{
	public String call(String v) ;
}
public class LambdaEx4 {
	public static void main(String[] args) {
		Ver m1 = (v) ->{
			return "Java" + v;
		};
		
		System.out.println(m1.call("ver 8.0"));
		
		
	}
}
