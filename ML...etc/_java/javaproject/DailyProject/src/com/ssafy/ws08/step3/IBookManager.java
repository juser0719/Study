package com.ssafy.ws08.step3;

//도서리스트를 관리하기 위한 인터페이스
public interface IBookManager {
	void add(Book book);
	void remove(String isbn);
	Book[] getList();
	Book searchByIsbn(String isbn);
	Book[] searchByTitle(String title);
	Magazine[] getMagazines();
	Book[] getBooks();
	int getTotalPrice();
	double getPriceAvg();
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	//추가
	void saveData();  //도서리스트를 파일에 저장한다
}