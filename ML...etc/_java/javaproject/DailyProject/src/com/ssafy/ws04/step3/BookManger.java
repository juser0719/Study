package com.ssafy.ws04.step3;

import java.util.Arrays;

public class BookManger {
	private static int MAX_SIZE=100;
	private Book[] books = new Book[MAX_SIZE];
	private int size;    //현재 등록된 도서수
	
	//도서 리스트에 추가
	public void add(Book book) {
		if(size < MAX_SIZE)	
			books[size++]=book;
	}
	
	//isbn으로 도서 삭제
	public void remove(String isbn) {
        for(int i=0; i<size; i++) {
            if(books[i].getIsbn().equals(isbn)) {
                books[i]=null;
                for(int j=i; j<size;j++) {
                    books[j] = books[j+1];
                }
                size--;
                break;
            }
        }
    }
/*	public void remove(String isbn) {
		for(int i=0; i<size; i++) {
            if(books[i].getIsbn().equals(isbn)) {
                books[i] = books[size-1];
                books[size-1]=null;
                size--;
                break;
            }
        }
	}*/
	
	//등록된 도서 리스트 반환
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}
	
	//isbn으로 조회
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
}


















