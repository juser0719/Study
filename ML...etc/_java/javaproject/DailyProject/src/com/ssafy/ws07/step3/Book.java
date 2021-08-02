package com.ssafy.ws07.step3;

public class Book  {
	public String isbn;
	public String title;
	public String author;
	public String publisher;
	public int price;
	public String desc;
	public int quantity;
	
	public Book() {
		super();
	}
	public Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity) {
		
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.quantity = quantity;
	}
	
	public String toString() {
		return isbn + "\t |" + title + "\t |" + author + "\t |" + publisher + "\t |" + price + "\t |" + desc + "\t |" + quantity;
	}
	
	public String getIsbn() {return isbn;}
	public String getTitle() {return title;}
	public String getAuthor() {return author;}
	public String getPublisher() {return publisher;}
	public int getPrice() {return price;}
	public String getDesc() {return desc;}
	public int getQuantity() {return quantity;}

	public void setQuantity(int quantity) {this.quantity = quantity;}
	public void setIsbn(String isbn) {this.isbn = isbn;}
	public void setTitle(String title) {this.title = title;}
	public void setAuthor(String author) {this.author = author;}
	public void setPublisher(String publisher) {this.publisher = publisher;}
	public void setPrice(int price) {this.price = price;}
	public void setDesc(String desc) {this.desc = desc;}
	

}
