package com.ssafy.ws07.step3;

import java.util.ArrayList;

public class BookManagerImpl implements IBookManager {
	private static IBookManager instance = null;
	public ArrayList<Book> books = new ArrayList<>();

	public static IBookManager getInstance() {
		if (instance == null) {
			instance = new BookManagerImpl();
		}
		return instance;
	}

	private BookManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	// 도서리스트에 추가
	@Override
	public void add(Book book) {
		books.add(book);
	}

	// isbn으로 도서 삭제
	@Override
	public void remove(String isbn) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
			}
			break;

		}
	}

	// 등록된 도서리스트 반환
	@Override
	public ArrayList<Book> getList() {
		return books;
	}

	//	 등록된 일반도서리스트 반환
	@Override
	public ArrayList<Book> getBooks() {
		int cnt = 0;
		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine))
				++cnt;
		}

		ArrayList<Book> result = new ArrayList<>();
		int idx = 0;
		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine)) {
				result.add(books.get(i));
			}
		}
		return result;
	}

	// 등록된 잡지리스트 반환
	@Override
	public ArrayList<Book> getMagazines() {
		int cnt = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) instanceof Magazine)
				++cnt;
		}

		ArrayList<Book> result = new ArrayList<>();
		int idx = 0;
		for (int i = 0; i < books.size(); i++) {
			if ((books.get(i) instanceof Magazine)) {
				result.add(books.get(i));
			}
		}
		return result;
	}

	// 모든 도서 가격 합계
	@Override
	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < books.size(); i++) {
			sum += books.get(i).getPrice();
		}
		return sum;
	}

	// 모든 도서 가격 평균
	@Override
	public double getPriceAvg() {
		return (double) getTotalPrice() / books.size();
	}

	// isbn으로 도서 조희
	@Override
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				return books.get(i);
			}
		}
		return null;
	}

	// title로 도서 조희
	@Override
	public ArrayList<Book> searchByTitle(String title) {
		BookManagerImpl bm = new BookManagerImpl();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().contains(title)) {
				bm.add(books.get(i));
			}
		}
		return bm.getList();
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		Book book = searchByIsbn(isbn);
		if(book!=null) {
			for(int i=0; i<instance.getList().size(); i++) {
				if(instance.getList().get(i).getIsbn().equals(isbn)) {
					instance.getList().get(i).setQuantity(instance.getList().get(i).getQuantity()+quantity);
				}
			}
		}else {
			throw new ISBNNotFoundException(isbn);
		}

	}

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantitiyException{
		Book book = searchByIsbn(isbn);
		if(book!=null) {
			if(book.getQuantity()>=quantity) {
				for(int i=0; i<instance.getList().size(); i++) {
					if(instance.getList().get(i).getIsbn().equals(isbn)) {
						instance.getList().get(i).setQuantity(instance.getList().get(i).getQuantity()-quantity);
					}
				}
			}else {
				throw new QuantitiyException();
			}
		}else {
			throw new ISBNNotFoundException(isbn);
		}
	}


}
