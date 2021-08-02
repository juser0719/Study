package com.ssafy.ws07.step3;

public class Magazine extends Book{
	int year;
	int month;
	public Magazine() {
		super();
	}
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int quantity, int year, int month) {
		super(isbn, title, author, publisher, price, desc,quantity);
		// TODO Auto-generated constructor stub
		this.year = year;
		this.month = month;
	}
	
	
	public int getYear() {return year;}
	public int getMonth() {return month;}
	public void setYear(int year) {this.year = year;}
	public void setMonth(int month) {this.month = month;}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("|");
		builder.append(year + "\t |");
		builder.append(month);
		return builder.toString();
	}
	
}
