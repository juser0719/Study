package com.ssafy.w0722.override;

class Test1{
	   public void view1() { System.out.println("view1 method"); }
	   public void view3() { System.out.println("view3 method"); }
	}
	class Test2 extends Test1{
	   public void view1() { System.out.println("view11 method"); }
	   public void view2() { System.out.println("view22 method"); }
	}
public class OverrideEx {
	public static void main(String[] args) {
		Test2 ob = new Test2();
	}
}
