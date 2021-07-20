package com.ssafy.w0719.control;

/* [문제] 65~90 사이의 임의의 난수를 10개 만드시오.
65 73 77 74 86 81 90 75 88 67
*/
public class Ex07_DoWhileEx2 {
	public static void main(String[] args) {

		for(int i = 0 ; i < 10 ; i ++)
			System.out.println((int)(Math.random() * 26 + 65));
	}
}
//---------------------------------------------------------------------------------------
/*
public class DoWhileEx2 {
	public static void main(String[] args) {
		System.out.println(Math.random());                    // 0 ~ 0.9999999
		System.out.println((int)(Math.random() * 10 + 1));    // 1 ~ 10 (gab+1, 시작값)
		                 // 0   ~   0.99999
		                 // 0   ~   9.99999  
		                 // 1   ~   10.9999
		                 // 1   ~   10
		System.out.println((int)(Math.random() * 21 + 50));    // 50 ~ 70
		                 // 0   ~   0.99999
		                 // 0   ~   20.9999
		                 // 50  ~   70.9999
		                 // 50  ~   70 
		System.out.println((int)(Math.random() * 20 + 51));    // 51 ~ 70
	}
}*/
/*
Math.random(): 0 ~ 0.9999999사이의 난수
*/
