package com.ssafy.w0727.interfaceex;

/* class와 interface를 이용하여 성적처리
 * 클래스명 : User
 *  -name:String
 *  +User()
 *  +User(name:String)
 *  +toString():String    --> "이름 : 홍길동" 를  리턴
 *  
 *  인터페이스명 : Score
 *  +sol:int           // 초깃값:20
 *  +getScore():int    // 맞은수 * sol을 리턴
 *  
 *  인터페이스명 : Print
 *  +toPaint():String
 *  
 *  [출력화면]
 *  이름 : 홍길동
 *  점수 : 60점
 */
class User {
	private String name;

	public User() {
		super();
	}
	
	public User(String name) {
		this.name = name;
	}

	public String toString() {
		return "이름 : " + name+'\n' ;
	}
	
}

interface Score {
	public int sol  = 20;
	public int getScore();
}

interface Print {
	public String toPaint();
}

public class InterfaceEx3 extends User implements Score ,Print {     // User,Score,Print 상속받기
	int s;   // 맞은수
	
	@Override
	public int getScore() {
		return s * sol;
	}
	@Override
	public String toPaint() {
		return super.toString()+"점수 : "+getScore()+"";
	};
	
	public InterfaceEx3(String name , int sol) {
		super(name);
		this.s = sol;
	}

	public static void main(String[] args) {
		InterfaceEx3 ob=new InterfaceEx3("홍길동", 3);
		System.out.println(ob.toPaint());
	}
}
