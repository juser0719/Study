package com.ssafy.w0728.lambda;

import java.util.ArrayList;
import java.util.List;


class Student {
	private String name;
	private int tot;
	
	public Student() {
		super();
	}

	public Student(String name, int tot) {
		super();
		this.name = name;
		this.tot = tot;
	}

	public String getName() {
		return name;
	}

	public int getTot() {
		return tot;
	}
	
	
	
}

public class LambdaEx8 {
	public static void main(String[] args) {
		List<Student> list=new ArrayList<>();
		
	      list.add(new Student("kim", 100));
	      list.add(new Student("lee", 70));
	      list.add(new Student("park", 85));
	      list.add(new Student("hong", 60));
	      list.add(new Student("kang", 95));
	      
	      list.forEach((m) -> System.out.println(m.getName() + ' ' + m.getTot()));
	      
	      list.sort((m1,m2)-> m1.getName().compareTo(m2.getName()));
	      
	      list.forEach((m) -> System.out.println(m.getName() + ' ' + m.getTot()));
	}
}
