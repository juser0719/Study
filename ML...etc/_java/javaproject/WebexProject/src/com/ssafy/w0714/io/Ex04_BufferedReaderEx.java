package com.ssafy.w0714.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BufferedReader, StringTokenizer를 이용한 입력받기
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
public class Ex04_BufferedReaderEx {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int test_case=Integer.parseInt(br.readLine());
        int[] sol=new int[test_case];
        
        for(int i=0; i<test_case; i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	
        	for(int j=0; j<10; j++) {
        		sol[i] += Integer.parseInt(st.nextToken());
        	}        	
        }
        
        for(int i=0; i<test_case; i++) {
        	System.out.println("#"+ (i+1) +" "+sol[i]);
        }
	}
}
//-------------------------------------------------------------------------
/*
public class Ex04_BufferedReaderEx {
	public static void main(String[] args) {
		String s="학교#학원,도서관/게임방 노래방#영화관";
		
		StringTokenizer st=new StringTokenizer(s,"#,/ ");   //구분자: # , / (공백)
		//System.out.println(st.countTokens());
		
		while(st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
	}
}
*/
//split: 구분자를 1개만 사용할수 있다.
//StringTokenizer: 구분자를 여러개 사용할수 있다.