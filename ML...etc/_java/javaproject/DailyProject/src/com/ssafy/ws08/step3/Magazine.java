package com.ssafy.ws08.step3;

//잡지 정보를 나타내는 클래스
public class Magazine extends Book {
	private int year;  // 발행년도
	private int month;  // 발행월
	
	public Magazine() {
		super();
	}
	//추가 - quantity
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month,int quantity) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("|");
		builder.append(year + "\t| ");
		builder.append(month);
		return builder.toString();
	}
}
