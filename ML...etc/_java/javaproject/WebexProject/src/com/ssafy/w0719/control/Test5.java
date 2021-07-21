package com.ssafy.w0719.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*[문제] 2자리의 난수를 발생하여 발생된 숫자를 맞추는 게임 프로그램
       (두자리의 난수: 10 - 99, Math클래스 사용)
       
[출력]
83  <---컴퓨터가 만든 수(화면에는 보이지 않아야 함)
*** 숫자 맞추기 게임을 시작합니다 *** 
숫자 입력: 50
컴퓨터의 숫자가 더 큽니다.

숫자 입력: 90
컴퓨터의 숫자가 더 작습니다.
      :

숫자 입력: 83
축하합니다.3번만에 맞추셨습니다.

한번 더 할까요(Y/y): n
**수고 하셨습니다 **
*/
public class Test5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int comsu;    // 컴퓨터 수
		int usersu;   // 사용자 수
		int cnt = 0;      // 카운트
		char sign;    // "한번 더 할까요?" 기억할 변수
		
		System.out.println("*** 숫자 맞추기 게임을 시작합니다 ***");
		int rand = (int)(Math.random()* 90+10);
		
		while(true) {
			int num;
			
			System.out.println("숫자 입력 : "); num = Integer.parseInt(br.readLine());
			cnt+=1;
			if(num == rand) {
				System.out.println("축하합니다." + cnt +"번만에 맞추셨습니다!");
				break;
			}
			
			if(num > rand)
				System.out.println("컴퓨터의 숫자가 더 작습니다.");
			else if (num < rand)
				System.out.println("컴푸터의 숫자가 더 큽니다.");
			
		}
	}
}



















