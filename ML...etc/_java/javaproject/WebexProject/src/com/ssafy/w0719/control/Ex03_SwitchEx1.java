package com.ssafy.w0719.control;

public class Ex03_SwitchEx1 {
	public static void main(String[] args) {
/*		char check='g';
		switch(check) 
		{
			case 'E': 
			case 'e': System.out.println("Excellent");	break;
			case 'G': 
			case 'g': System.out.println("Good");		break;
			default:  System.out.println("Bad");
		}*/
		//-------------------------------------------------------
		char check='g';
		
		if(check=='e' || check=='E') {
			System.out.println("Excellent");
		}else if(check=='g' || check=='G') {
			System.out.println("Good"); 
		}else {
			System.out.println("bad");
		}
	}
}





