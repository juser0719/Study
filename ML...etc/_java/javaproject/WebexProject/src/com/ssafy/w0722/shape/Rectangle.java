package com.ssafy.w0722.shape;
/* Rectangle는  Shape를 상속받음
* 
*  +Rectangle()
*  +Rectangle(data1:int , data2:int)
*  +getSize():double            ==>사각형의 넓이를 리턴(가로 * 세로) 
*/
public class Rectangle extends Shape {
	public Rectangle () {
		
	}
	public Rectangle(int data1,int data2) {
		super(data1,data2);
	}
	public double getSize() {
		return (double)super.getData1() * super.getData2();
	}
}
