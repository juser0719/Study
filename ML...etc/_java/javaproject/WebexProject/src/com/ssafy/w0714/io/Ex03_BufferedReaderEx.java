package com.ssafy.w0714.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03_BufferedReaderEx {
	public static void main(String[] args) throws IOException {
//		InputStreamReader isr=new InputStreamReader(System.in);
//		BufferedReader br=new BufferedReader(isr);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name;
		int age;
		float tall;
		double weight;
		char gender;

		System.out.print("이름:"); name=br.readLine();
		System.out.print("나이:"); age=Integer.parseInt(br.readLine());   // "26" --> 26
		System.out.print("신장:"); tall=Float.parseFloat(br.readLine());
		System.out.print("체중:"); weight=Double.parseDouble(br.readLine());
		System.out.print("성별:"); gender=br.readLine().charAt(0);
		
		System.out.println("나의 이름은 " + name + "입니다");
		System.out.println("나의 나이는 " + age + "세 입니다");
		System.out.println("나의 신장은 " + tall + "cm 입니다");
		System.out.println("나의 체중은 " + weight + "kg 입니다");
		System.out.println("나의 성별은 " + gender + "자 입니다");
	}
}






