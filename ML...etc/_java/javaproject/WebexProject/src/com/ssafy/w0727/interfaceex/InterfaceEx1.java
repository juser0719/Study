package com.ssafy.w0727.interfaceex;

interface Shape{
	int r = 0;
	public void draw();
	public void erase();
}

//abstract class Shape {
//	final int r = 0;
//	abstract public void draw();
//	abstract public void erase();
//	
//}
class Circle implements Shape {
	
	@Override
	public void draw() {
		System.out.println("d");
	}
	@Override
	public void erase() {
		System.out.println("o");
	}
	
}
public class InterfaceEx1 {

	public static void main(String[] args) {
		
	}
}
