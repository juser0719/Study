package com.ssafy.w0714.io;

import java.util.Scanner;

/* 입력받기
1. Scanner          <--- jdk 1.5이상, 성능이 BufferedReader보다 떨어짐
2. BufferedReader   <--- 성능이 더 좋음
*/
public class Ex01_Sacnner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		float tall;
		double weight;
		char gender;

		System.out.print("이름:"); name=sc.next();
		System.out.print("나이:"); age=sc.nextInt();
		System.out.print("신장:"); tall=sc.nextFloat();
		System.out.print("체중:"); weight=sc.nextDouble();
		System.out.print("성별:"); gender=sc.next().charAt(0);
		
		System.out.printf("%-10s   %d   %.2f   %.1f   %c", name,age,tall,weight,gender);
		sc.close();
	}
}
