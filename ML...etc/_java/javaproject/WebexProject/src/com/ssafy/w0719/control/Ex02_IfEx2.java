package com.ssafy.w0719.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*[문제] 중첩if를 이용하여 프로그램을 작성하시오(Scanner, BufferedReader 택1)
3과목의 점수를 입력받아서 합격이지 불합격인지 출력하시오
3개의 과목이 전부 40이상이어야 하고 평균이 60이어야 "합격" 출력
평균이 60이 넘지만 1개의 과목이라도 40 미만이면 "과락으로 불합격" 출력
평균이 60미만이면 "불합격" 출력

[실행결과]
국어점수입력 : 75  
영어점수입력 : 80  
수학점수입력 : 100
결과 = 합격

국어점수입력 : 95  
영어점수입력 : 80  
수학점수입력 : 39
결과 = 과락으로 불합격

국어점수입력 : 45  
영어점수입력 : 47 
수학점수입력 : 65
결과 = 불합격 
*/
public class Ex02_IfEx2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int kor,eng,mat,tot=0;
		double avg=0.0;
		
		System.out.print("국어점수를 입력: "); kor=Integer.parseInt(br.readLine());
		System.out.print("영어점수를 입력: "); eng=Integer.parseInt(br.readLine());
		System.out.print("수학점수를 입력: "); mat=Integer.parseInt(br.readLine());
		
		tot=kor+eng+mat;
		avg=(double)tot/3;
		
		if(avg>=60) {
			if(kor<60 || eng<60 || mat<60) {
				System.out.println("결과 = 과락으로 불합격");
			}else {
				System.out.println("결과 = 합격");
			}
		}else {
			System.out.println("결과 = 불합격");
		}

	}
}
