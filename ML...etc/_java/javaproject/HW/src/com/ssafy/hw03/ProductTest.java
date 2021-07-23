package com.ssafy.hw03;

class TV{
	
	private int product_num;
	private String name;
	private int price;
	private int num;
	private int inch;
	private char type;
	
	public TV() {
		super();
	}

	public TV(int product_num, String name, int price, int num,int inch, char type) {
		super();
		this.product_num = product_num;
		this.name = name;
		this.price = price;
		this.num = num;
		this.inch = inch;
		this.type = type;
	}

	@Override
	public String toString() {
		return "** TV **\n제품번호: " + product_num + "\n제품이름: " + name + "\n가격: " + price + "\n수량: " + num +"\n인치:" + inch + "\n디스플레이 타입:"
				+ type + "\n";
	}

}

class Refrigerator {
	
	private int product_num;
	private String name;
	private int price;
	private int num;
	private int cap;
	
	
	public Refrigerator() {
		super();
	}

	public Refrigerator(int product_num, String name, int price, int num, int cap) {
		super();
		this.product_num = product_num;
		this.name = name;
		this.price = price;
		this.num = num;
		this.cap = cap;
	}
	
	@Override
	public String toString() {
		return "** Refrigerator **\n제품번호: " + product_num + "\n제품이름: " + name + "\n가격: " + price + "\n수량: " + num + "\n용량:"
				+ cap + "\n";
	}
	
}

public class ProductTest {
	public static void main(String[] args) {
		TV tv = new TV(100,"TV",500000,100,55,'A');
		Refrigerator ref = new Refrigerator(201,"냉장고",1000000,200,500);
		
		System.out.println(tv.toString()+ref.toString());
		
	}
}
