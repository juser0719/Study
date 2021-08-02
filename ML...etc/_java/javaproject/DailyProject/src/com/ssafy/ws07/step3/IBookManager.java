package com.ssafy.ws07.step3;

import java.util.ArrayList;

public interface IBookManager {
	void add(Book book);
	void remove(String isbn);
	ArrayList<Book> getList();
	Book searchByIsbn(String isbn);
	ArrayList<Book> searchByTitle(String title);
	ArrayList<Book> getMagazines();
	ArrayList<Book> getBooks();
	int getTotalPrice();
	double getPriceAvg();
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantitiyException;
}
