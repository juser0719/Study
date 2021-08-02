package com.ssafy.ws08.step3;

import java.io.Serializable;

public class Book implements Serializable {
	private String isbn;	    // 고유번호	
	private String title;	    // 제목	
	private String author;	    // 저자	
	private String publisher;	// 출판사
	private int price;			// 가격
	private String desc;		//설명
	private int quantity;       //재고수량 -추가

	public Book() {
		super();
	}
	//추가
	public Book(String isbn, String title, String author, String publisher, int price, String desc,int quantity){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.quantity = quantity;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	//추가
	public int getQuantity() {
		return quantity;
	}
	//추가
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//추가
	public String toString() {
		return isbn + '\t' + "| " + title + "  \t" + "| " + author + '\t' + "| " + publisher + '\t'
				+ "| " + price + '\t' + "| " + desc + '\t'+ "| " + quantity + '\t';
	}
}