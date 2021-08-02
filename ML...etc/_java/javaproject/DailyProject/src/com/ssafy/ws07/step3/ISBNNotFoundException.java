package com.ssafy.ws07.step3;

public class ISBNNotFoundException extends Exception{
	String isbn;
	public ISBNNotFoundException (String isbn) {
		super("isbn: "+isbn+"해당 도서가 존재하지 않습니다.");
		this.isbn = isbn;
		
	}
	
	public String getIsbn() {
		return isbn;
	}
}
