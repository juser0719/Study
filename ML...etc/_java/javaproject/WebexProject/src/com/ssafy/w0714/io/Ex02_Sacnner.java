package com.ssafy.w0714.io;

import java.util.Scanner;

//Scanner를 이용한 입력받기
/*
[입력]
3
3 4 5 1 3 4 5 1 4 5
6 7 8 5 4 2 1 5 6 7
4 5 6 7 2 5 7 6 1 1

[출력]
#1 35
#2 51
#3 44
*/
public class Ex02_Sacnner {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cnt=sc.nextInt();
		sc.nextLine();   // "엔터"처리
		
		int[] sum=new int[cnt];   // 35  51  44
		for(int i=0; i<cnt; i++) {
			String[] s=sc.nextLine().split(" ");  // "3 4 5 1 3 4 5 1 4 5 엔터"
			
			for(int j=0; j<s.length; j++) {
				sum[i] += Integer.parseInt(s[j]); // "3" --> 3
			}
		}
		
		//출력-----------------
		for(int i=0; i<cnt; i++) {
			System.out.println("#" + (i+1) +" " + sum[i]);
		}
	}
}
//-------------------------------------------------------------
/*
2 4 5 1 3 4 5 1 4 5
2
4
5
1
3
4
5
1
4
5
*/
/*
public class Ex02_Sacnner {
	public static void main(String[] args) {
		String s="2 4 5 1 3 4 5 1 4 5";
		
		String[] s_num=s.split(" ");   //split("구분자"): 구분자로 데이터를 자름
		for(int i=0; i<s_num.length; i++) {
			System.out.println(s_num[i]);
		}		
	}
}
*/



