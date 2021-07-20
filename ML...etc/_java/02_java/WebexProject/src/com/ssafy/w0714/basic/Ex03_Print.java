package com.ssafy.w0714.basic;

public class Ex03_Print {
	public static void main(String[] args) {
		String name="홍길동";
		int age=25;                  // int(4byte)
		float weight=75.3f;          // float(4byte) 
		char gender='남';             // char(2byte)
		double tall=175.3;           // double(8byte)
		
		System.out.print("나의 이름은 "+name+" 입니다\n");
		System.out.print("나의 이름은 "+name+" 입니다\n");
		System.out.print("나의 나이는 "+age+"세 입니다\n");       
		System.out.print("나의 체중은 "+weight+"kg입니다\n");    
		System.out.print("나의 성별은 "+gender+"자 입니다\n");     
		System.out.print("나의 키은 "+tall+"cm입니다\n");   
	}
}
/*
나의 이름은 홍길동 입니다
나의 나이는 25세 입니다           <--- age(정수)
나의 체중은 75.3kg입니다       <--- weight(실수, float)
나의 성별은 남자 입니다            <--- gender(문자)
나의 키은 175.3cm입니다        <--- tall(실수, double)
*/