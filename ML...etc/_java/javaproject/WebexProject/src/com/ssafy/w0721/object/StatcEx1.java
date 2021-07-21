package com.ssafy.w0721.object;

class Test {
	   int a;
	   int b;
	   static int c;

	   public Test(int a, int b, int c1) {
	      this.a = a;
	      this.b = b;
	      c = c1;
	      System.out.println("객체의 초기화 영역 ");
	   }
	   static {
		   System.out.println("static reset");
	   }
	   public void view() {
	      System.out.println(a+" "+b+" "+c);
	   }
	}

public class StatcEx1 {
	public static void main(String[] args) {
		Test ob1 = new Test(1,2,3);
		Test ob2 = new Test(5,6,7);
		
		ob1.view();
		ob2.view();
	}
}
