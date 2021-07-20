package com.ssafy.w0714.basic;

//형변환: 자동형변환, 강제형변환
public class Ex05_Casting {
	public static void main(String[] args) {
//		int salary=857650;
//		double tax=0.033;
//		int result=salary-(int)(salary*tax);  //hit)급여-(급여*세금)
//		
//		System.out.println("세금은 제외한 급여:" + result);  //830348
		//----------------------------------------------------------
		int k=87, e=88, m=75;
		double avg=(k+e+m)/3.0;           //자동형변환
		double avg2=(double)(k+e+m)/3;    //강제형변환
		
		System.out.printf("평균:%.2f점\n", avg);
		System.out.printf("평균:%.2f점\n", avg2);
	}
}
