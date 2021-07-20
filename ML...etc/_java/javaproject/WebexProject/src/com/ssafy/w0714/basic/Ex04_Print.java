package com.ssafy.w0714.basic;

public class Ex04_Print {
	public static void main(String[] args) {
		String name="홍길동";          // String ( %s )
		int age=25;                  // byte, short, int, double ( %d )
		float weight=75.3f;          // float, double ( %f ) 
		char gender='남';             // char( %c )
		double tall=175.3;           
		
		System.out.printf("나의 이름은 %s입니다\n", name);
		System.out.printf("나의 나이는 %d세 입니다\n",age);       
		System.out.printf("나의 체중은 %.2fkg입니다\n",weight);    
		System.out.printf("나의 성별은 %c자 입니다\n",gender);      
		System.out.printf("나의 키은 %.1fcm입니다\n",tall);  
	}
}
