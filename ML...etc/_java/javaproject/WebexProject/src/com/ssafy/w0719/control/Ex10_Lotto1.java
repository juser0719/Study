package com.ssafy.w0719.control;

import java.util.Arrays;
import java.util.Random;

public class Ex10_Lotto1 {
public static void main(String[] args) {
	int nums[] = new int[6];
	Random rand = new Random();
	
	for (int i = 0 ; i < nums.length; i++)
	{
		nums[i] = (rand.nextInt((45)) + 1);
		
		for (int j = 0 ; j < i ; j ++) {
			if (nums[i] == nums[j])
				i--;
		}
	}
	
	Arrays.sort(nums);
	for (int num : nums)
		System.out.print(num +" ");
}
}
