package com.ssafy.ws07.step3;

import java.util.ArrayList;

public class BookTest {
	public static void main(String[] args){
		Book ob1 = new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 기본문법",10);
		Book ob2 = new Book("21415","Java Pro2","김하나","jaen.kr",25000,"Java 응용",20);
		Book ob3 = new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링",30);
		Magazine mg = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1);
		IBookManager bm = BookManagerImpl.getInstance();
		bm.add(ob1);
		bm.add(ob2);
		bm.add(ob3);
		bm.add(mg);
		
		System.out.println("**********도서전체 목록**********");
		for(Book book : bm.getList()) {
			System.out.println(book);
		}
		System.out.println("**********일반도서 목록**********");
		for(Book book : bm.getBooks()) {
			System.out.println(book);
		}
		System.out.println("**********잡지도서 목록**********");
		for(Book book : bm.getMagazines()) {
			System.out.println(book);
		}
		System.out.println("**********도서제목포함검색 : Java**********");
		ArrayList<Book> books = bm.searchByTitle("Java");
		for(Book book : books) {
			System.out.println(book);
		}
		System.out.println("**********도서번호검색 : 21424**********");
		Book book = bm.searchByIsbn("21424");
		System.out.println(book);
		System.out.println("**********도서판매 : 21424,11개**********");
		try {
			bm.sell("21424", 11);
		}catch(ISBNNotFoundException e){
			e.printStackTrace();
		}catch(QuantitiyException e) {
			e.printStackTrace();
		}
		System.out.println("**********도서구매 : 21424,10개**********");
		try {
			bm.buy("21424", 10);
		}catch(ISBNNotFoundException e){
			e.getStackTrace();
		}
		System.out.println(bm.searchByIsbn("21424"));
		System.out.println("**********도서판매 : 21424,11개**********");
		try {
			bm.sell("21424", 11);
		}catch(ISBNNotFoundException e){
			e.printStackTrace();
		}catch(QuantitiyException e) {
			e.printStackTrace();
		}
		System.out.println(bm.searchByIsbn("21424"));
		System.out.println("**********도서번호검색 : Java**********");
		book = bm.searchByIsbn("21424");
		System.out.println(book);
		System.out.println("도서 가격 총합 : "+bm.getTotalPrice());
		System.out.println("도서 가격 평균 : "+bm.getPriceAvg());

//		System.out.println("**********도서조회 : 21424**********");
//		System.out.println(bm.searchByIsbn("21424").toString());
//		System.out.println("**********도서삭제 : 21424**********");
//		bm.remove("21424");
//		System.out.println("**********도서목록**********");
//		for(Book book : bm.getBooks()) {
//			System.out.println(book);
//		}
		
	}
}
