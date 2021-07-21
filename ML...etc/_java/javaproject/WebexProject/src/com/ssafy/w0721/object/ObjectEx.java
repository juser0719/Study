package com.ssafy.w0721.object;

public class ObjectEx extends Object{
	String name = "홍길동";
	public ObjectEx() {
//		super();
		System.out.println(this.name.toString());
	}
	
	public void view() {
		System.out.println(this.name.toString());
	}
	
	public static void main(String[] args) {
		ObjectEx ob = new ObjectEx();
//		ob.view();
		
	}

}
