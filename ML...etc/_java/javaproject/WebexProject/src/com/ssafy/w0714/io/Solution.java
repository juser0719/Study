package com.ssafy.w0714.io;

import java.util.Scanner;

//홀수만 더하기(2072-D1)
public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cnt=sc.nextInt();
		sc.nextLine();   
		
		int[] sum=new int[cnt];   
		for(int i=0; i<cnt; i++) {
			String[] s=sc.nextLine().split(" ");  
			
			for(int j=0; j<s.length; j++) {
				int n=Integer.parseInt(s[j]); 
				if(n%2==1)
					sum[i] += n;
			}
		}
		
		for(int i=0; i<cnt; i++) {
			System.out.println("#" + (i+1) +" " + sum[i]);
		}
	}
}
