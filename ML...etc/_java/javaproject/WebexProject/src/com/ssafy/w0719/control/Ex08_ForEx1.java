package com.ssafy.w0719.control;

public class Ex08_ForEx1 {
public static void main(String[] args) {
	int[] n  = {10,20,30,40,50,60,70,80,90,100};
	for(int i = 1 ;i <  n.length; i+=2) {
		System.out.print(n[i] + " ");
	}
	System.out.println();
	
	String str = "Have a nice day";
	
	for(int i = str.length()-1; i >= 0 ; i--) {
		System.out.print(str.charAt(i));
	}
}
}
