package com.ssafy.ws05.step3;

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

	//일반 도서(잡지 제외)
	public Book[] getBooks() {
		int cnt=0;
		for(int i=0; i<size; i++) {
			if(!(books[i] instanceof Magazine))
					++cnt;
		}
		
		Book[] result = new Book[cnt];
		int idx=0;
		for(int i=0; i<size; i++) {
			if(!(books[i] instanceof Magazine)) {
				result[idx++] = books[i];
			}
		}
		return result;
	}

	//잡지(일반도서 제외)
	public Magazine[] getMagazines() {
		int cnt=0;
		for(int i=0; i<size; i++) {
			if(books[i] instanceof Magazine)
					++cnt;
		}
		
		Magazine[] result = new Magazine[cnt];
		int idx=0;
		for(int i=0; i<size; i++) {
			if(books[i] instanceof Magazine) {
				result[idx++] = (Magazine)books[i];
			}
		}
		return result;
	}

	//제목으로 도서 찾기
	public Book[] searchByTitle(String title) {
		int cnt=0;
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title))  // 비교
				++cnt;
		}
		
		Book[] result = new Book[cnt];
		int idx=0;
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) { //배열에 담기
				result[idx++] = books[i];
			}
		}
		return result;
	}

	//모든 도서 가격합계
	public int getTotalPrice() {
		int tot=0;
		for(int i=0; i<size; i++) {
			tot += books[i].getPrice();
		}
		return tot;
	}

	//모든 도서 가격평균
	public double getPriceAvg() {
		return (double)getTotalPrice()/size;
	}
}


















