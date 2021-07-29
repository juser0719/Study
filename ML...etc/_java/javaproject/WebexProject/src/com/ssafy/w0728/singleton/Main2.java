package com.ssafy.w0728.singleton;
/* 싱글톤패턴(Singleton Pattern): 하나의 인스턴스만을 생성하고 사용할 경우에 쓴다 */
public class Main2 {
	public static void main(String[] args) {
		Speaker2 s1 = Speaker2.getSpeaker();
		Speaker2 s2 = Speaker2.getSpeaker();
		Speaker2 s3 = Speaker2.getSpeaker();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		
	}
}
