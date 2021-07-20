package com.ssafy.alog;

import java.util.Arrays;
import java.util.Scanner;




public class DigitTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[100];
		int idx = 0;
		
		while(true)
		{
			int num = sc.nextInt();
			if (num == 0)
				break;
			nums[idx] = num;
			idx ++;
		}
		
		Arrays.sort(nums);
		int flg = -1 ;
		for(int i = 100-idx; i < 100; i++) {
			int cnt = 0;
			int ten = (nums[i]%100)/10;
			if (flg == ten)
				continue;
			else {
				flg = ten;
				for(int j = i ; j < 100; j ++) {
				if((nums[j]%100)/10 == ten)
					cnt+=1;
				}
				
			}
			
			
			System.out.println(ten + ": " + cnt);
		}
		
	
//		10 55 2 63 85 61 85 0
	}
}
