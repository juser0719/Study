package com.ssafy.hw07;

public class Product {
	private String name;
	private int number;
	private int price;
	private int total;
	
	public Product() {
		super();
	}

	public Product(String name, int number, int price, int total) {
		super();
		this.name = name;
		this.number = number;
		this.price = price;
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "[상품명 =" + name + ", 상품 번호 =" + number + ", 가격 =" + price + ", 재고 수량 =" + total + "]";
	}
	
}
