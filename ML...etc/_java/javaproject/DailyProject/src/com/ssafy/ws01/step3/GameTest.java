package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승 \n2. 3판 2승 \n3. 1판 1승");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int win_max = 0;
		int win = 0, cnt = 0 ;
		switch (num) {
		case 1: win_max = 3;break;
		case 2: win_max = 2;break;
		case 3: win_max = 1;break;
		}
		
		while(cnt != win_max) {
			int computer = (int)(Math.random() *3)+ 1;
			System.out.println("가위바위보 중 하나 입력 :");
			String user = sc.next();
			
			switch (user) {
			case "가위" :
				if (computer == 2) {
					System.out.println("졌습니다..!");	
					win -= 1;		
				}
				else if (computer == 3) {
					System.out.println("이겻습니다..!");
					win += 1;
				}
				cnt += 1;
				break;
			case "주먹" :
				if (computer == 2) {
					System.out.println("졌습니다..!");	
					win -= 1;		
				}
				else if (computer == 1) {
					System.out.println("이겻습니다..!");
					win += 1;
				}
				cnt += 1;
				break;
			case "보" :
				if (computer == 1) {
					System.out.println("졌습니다..!");	
					win -= 1;		
				}
				else if (computer == 2) {
					System.out.println("이겻습니다..!");
					win += 1;
				}
				cnt += 1;
				break;
			default:
				System.out.println("가위 , 주먹 , 보 로만 입력해주세요!!");
			}
			
		}
		if (win > 0 )
			System.out.println("### 사용자 승!!!");
		else
			System.out.println("### 컴퓨터 승!!!");
	}
}