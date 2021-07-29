package com.ssafy.w0728.singleton;

public class Main1 {
	public static void main(String[] args) {
		Speaker1 s1 = new Speaker1();
		Speaker1 s2 = new Speaker1();
		Speaker1 s3 = new Speaker1();
		
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		s1.setVolume(10);
	}
}
