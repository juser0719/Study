package com.ssafy.w0719.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06_DoWhileEx1 {
	public static void main(String[] args) throws Exception {
		// 점수를 입력받아 0~100사이인 경우만 출력하시오(do-while)
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int score;
		
		do {
			System.out.print("점수를 입력하시오: ");
			score=Integer.parseInt(br.readLine());
		}while(score<0 || score>100);
		
		System.out.println("당신의 점수는 " + score +"점 입니다");
		
		// do-while을 이용해서 "I like Algorithm"를 5번 출력------------------
/*		int num=0;
		do {
			System.out.println("I like Algorithm");
			num++;
		}while(num<5);*/
		
		
		// while을 이용해서 "Hello World"를 5번 출력--------------------------
/*		int cnt=0;
		while(true) {
			cnt++;
			if(cnt <= 5) {
				System.out.println("Hello World");
			}else {
				break;
			}
		}*/
	}
}
