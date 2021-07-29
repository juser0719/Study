package com.ssafy.w0728.compare;

import java.util.Arrays;
import java.util.Comparator;

//기본 생성자, 인자3개받는 생성자, toString()
class Student2 implements Comparable<Student2>{
	String name;
	int num;
	double score;
	
	public Student2() {
		super();
	}
	public Student2(String name, int num, double score) {
		super();
		this.name = name;
		this.num = num;
		this.score = score;
	}
	@Override
	public String toString() {
		return name+" "+num+" "+score;
	}
	
	@Override
	public int compareTo(Student2 o) {
		//return this.name.compareTo(o.name);         //오름차순(이름)
	    //return Double.compare(this.score,o.score);    //오름차순(점수)
	    //return Integer.compare(o.num, this.num);      //this가 앞에 있으면 오름차순/뒤에 있으면 내림차순
		return this.name.compareTo(o.name);
	}
}
public class StudentMain2 {
	public static void main(String[] args) {
		Student2[] s=new Student2[5];
		s[0]=new Student2("Dave",20170301, 4.5);
		s[1]=new Student2("Amie",20160301, 3.5);
		s[2]=new Student2("Emma",20180301, 2.5);
		s[3]=new Student2("Brad",20150301, 4.5);
		s[4]=new Student2("Cara",20150302, 3.5);

		Arrays.sort(s);

		for(int i=0; i<s.length; i++) {
			System.out.println(s[i]);   
		}
	}
}














