package com.ssafy.w0722.shape;



/*
사각형의 넓이: 20
삼각형의 넓이: 10.5
*/
public class ShapeMain {
	public static void main(String[] args) {
		Rectangle ob1 = new Rectangle(4,5);
		System.out.println("사각형의 넓이 : "+ ob1.getSize());
		
		Triangle ob2 = new Triangle(4,5);
		System.out.println("사각형의 넓이 : "+ ob2.getSize());
		
	}
}
