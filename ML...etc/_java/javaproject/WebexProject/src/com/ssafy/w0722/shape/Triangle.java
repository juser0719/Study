package com.ssafy.w0722.shape;

/*  Triangle는  Shape를 상속받음
* 
*  +Triangle()
*  +Triangle(data1:int , data2:int)
*  +getSize():double            ==>삼각형의 넓이를 리턴(밑변 * 높이 /2) 
*/
class Triangle extends Shape {
	public Triangle () {
		
	}
	public Triangle(int data1,int data2) {
		super(data1,data2);
	}
	@Override
	public double getSize() {
		return super.getData1()*super.getData2()/2.0;
	}
}

