package com.ssafy.w0720.object;

class Person{
	public String name;
	public int age;
	public float score;
	public void setPerson(String name,int age, float score) {
		this.name = name;
		this.age = age;
		this.score = score;
				
	}
	public void viewPerson () {
		System.out.println("이름 : " +  name);
		System.out.println("나이 : " +  age);
		System.out.println("점수 : " +  score);
	}
}

public class ObjectEx1 {
	public static void main(String[] args) {
		Person ob1 = new Person();
		ob1.setPerson("전웅재", 26, 100);
		ob1.viewPerson();
	}
}
