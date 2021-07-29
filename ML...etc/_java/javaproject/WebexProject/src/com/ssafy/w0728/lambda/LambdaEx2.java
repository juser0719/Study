package com.ssafy.w0728.lambda;

//class MyThread implements Runnable{
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		System.out.println("Hello Thread");
//	}
//}


public class LambdaEx2 {
	public static void main(String[] args) {
		new Thread(() ->System.out.println("Hello Thread")).start();
	}
}
