package com.ssafy.w0722.inhritance;

class Branch{
	public Branch() {}
	public Branch(String str) {
		this();
		
	}
}

class Leaf extends Branch {
	public Leaf(String str) {
		super(str);
		System.out.println(str + " Constructor");
	}
}


public class InheritanceEx3 {
	public static void main(String[] args) {
		new Leaf("ABC");
	}
}
