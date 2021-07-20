package com.ssafy.w0719.control;

public class Ex01_IfEx1 {
	public static void main(String[] args) {
		// if~else if문--------------------------------
		// 90점이상 A, 80점 이상 B, 70이상 C, 60점 이상 D, 나머지 F
/*		int score=95;
		char grade;
		
		if(score>=90)			grade='A';
		else if(score>=80)		grade='B';
		else if(score>=70)		grade='C';
		else if(score>=60)		grade='D';
		else					grade='F';
		
		System.out.println("나의 점수는 "+score+"점 이고 학점은 "+grade+"입니다");*/
		//--------------------------------------------------------------------
/*		int score=95;
		char grade;  //초기화를 생략할 수 있다
		
		switch(score/10) 
		{
			case 10:
			case 9:	  grade='A';  break;
			case 8:	  grade='B';  break;
			case 7:	  grade='C';  break;
			case 6:	  grade='D';  break;
			default:  grade='F';
		}
		System.out.println("나의 점수는 "+score+"점 이고 학점은 "+grade+"입니다");*/
		
		//--------------------------------------------------------------------
		int score=85;
		char grade='\0';   //초기화를 생략할 수 없다
		
		if(score>100 || score<0) {
			System.out.println("점수 오류!!!");
			return;
		}
		
		if(score<=100 && score>=90)		grade='A';
		if(score<90 && score>=80)		grade='B';
		if(score<80 && score>=70)		grade='C';
		if(score<70 && score>=60)		grade='D';
		if(score<60 && score>=0)		grade='F';
		System.out.println("나의 점수는 "+score+"점 이고 학점은 "+grade+"입니다");
	}
}





