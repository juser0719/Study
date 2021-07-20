package com.ssafy.w0720.object;
class Member {
	private String name;
	private int age;
	private double tall;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName () {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getTall() {
		return tall;
	}
	public void setTall(double tall) {
		this.tall = tall;
	}
	
}
public class ObjectEx3 {
	public static void main(String[] args) {
		Member ob = new Member();
		ob.setName("전웅재");
		ob.setAge(26);
		ob.setTall(177.7);
		
		System.out.println(ob.getName() +" "+ ob.getAge()+ " " + ob.getTall());
	}
}
