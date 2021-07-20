package com.ssafy.w0719.control;

import java.util.Arrays;

public class Ex09_ForEx2 {
	   public static void main(String[] args) {
	      int cnt = 0;
	      int[] prime = new int[50];
	      
	      for(int i = 1; i<=prime.length ; i++) {
	    	 
	         for(int j= 1; j < i ; j++) {
	            if(j !=1 &&  i % j == 0 ) {
	               break;
	            }
	            if( j +1 == i) {
	               prime[cnt] = i;
	               cnt++;
	               
	            }
	            
	         }
	      }
	      System.out.println(cnt);
	      for (int i =0 ; i < cnt; i ++) {
	    	  System.out.print(prime[i]+ " ");
	      }
	   }
	}
