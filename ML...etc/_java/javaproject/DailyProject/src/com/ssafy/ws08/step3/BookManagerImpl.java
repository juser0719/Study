package com.ssafy.ws08.step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//도서리스트를 컬렉션으로 유지하며 관리하는 클래스
public class BookManagerImpl implements IBookManager {
	
	private List<Book> books = new ArrayList<Book>(); // 배열 대신 List유형의 컬렉션 사용
	
	private static IBookManager instance = new BookManagerImpl();
	
	// 추가 -- loadData()
	private BookManagerImpl() { // 외부에서 객체 생성을 하지 못하도록 접근 제어자를  private으로 만든 생성자
		loadData();				// 객체 생성시 기존에 저장된 데이터를 로드한다
	}
	
	//내부에서 생성한 객체의 참조값을 반환한다----------------------------------------------------------------------
	public static IBookManager getInstance() {
		return instance;
	}

	//도서를 도서리스트에 추가한다.
	@Override
	public void add(Book book) {
		books.add(book);	// 리스트 마지막에 추가
	}
	
	//고유번호로 해당 도서를 도서리스트에서 삭제한다----------------------------------------------------------------------
	@Override
	public void remove(String isbn){
		final int size = books.size();	// 저장되어 있는 도서개수 확인
		for (int i = 0; i < size; ++i) {
			// 삭제할 도서를 찾았다면 해당 도서 위치를 이용하여 리스트에서 도서 삭제
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}
	}
	
	//등록된 도서리스트를 반환한다----------------------------------------------------------------------
	@Override
	public Book[] getList() {
		Book[] result = new Book[books.size()];	// 저장되어 있는 도서개수 만큼의 배열 생성
		return books.toArray(result);			// 컬렉션 내용을 배열로 복사 후 배열 리턴 
	}
	
	//고유번호로 해당 도서를 조회한다---------------------------------------------------------------------------
	@Override
	public Book searchByIsbn(String isbn) {		
		for (Book book : books) {
			if(book.getIsbn().equals(isbn)) return book;
		}
		return null;
	}
	
	//도서 제목을 포함하고 있는 도서리스트를 반환한다-----------------------------------------------------------------
	@Override
	public Book[] searchByTitle(String title) {
		// 제목을 포함하는 도서의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(book.getTitle().contains(title)) temp.add(book);
		}
		Book[] result = new Book[temp.size()];  // 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		return temp.toArray(result); 			// 컬랙션의 내용을 배열로 복사 후 리턴
	}
	
	//잡지리스트를 반환한다--------------------------------------------------------------------------------
	@Override
	public Magazine[] getMagazines() {
		// 잡지의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Magazine> temp = new ArrayList<Magazine>();
		for (Book book : books) {
			if(book  instanceof Magazine) temp.add((Magazine)book);
		}		
		Magazine[] result = new Magazine[temp.size()];  // 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		return temp.toArray(result); 					// 컬랙션의 내용을 배열로 복사 후 리턴
	} 
	
	// 잡지가 아닌 도서리스트를 반환한다----------------------------------------------------------------------
	@Override
	public Book[] getBooks() {
		// 일반 도서의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
		ArrayList<Book> temp = new ArrayList<Book>();
		for (Book book : books) {
			if(!(book  instanceof Magazine)) temp.add(book);
		}
		Book[] result = new Book[temp.size()];	// 조회 결과를 담은 컬렉션의 크기를 활용하여 배열 생성
		return temp.toArray(result); 			// 컬랙션의 내용을 배열로 복사 후 리턴
	}
	
	//도서리스트의 가격의 총합을 반환한다----------------------------------------------------------------------
	@Override
	public int getTotalPrice() {
		int total = 0;
		for (Book book : books) {
			total += book.getPrice();
		}
		return total;
	}
	
	//도서가격의 평균을 반환한다.
	@Override
	public double getPriceAvg() {
		return (double)getTotalPrice()/ books.size();
	}
	
	//고유번호에 해당하는 도서를 수량만큼 판매 처리하여 재고를 감소시킨다------------------------------------------------
	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book book = searchByIsbn(isbn);				// 고유번호 도서 조회
		if(book == null) throw new ISBNNotFoundException(isbn); // 고유번호 도서 조회 실패시 ISBNNotFoundException 사용자 정의 예외 발생시킴
		
		int res = book.getQuantity() - quantity;	// 판매 후 새로운 재고 수량 계산
		if(res < 0) throw new QuantityException();	// 재고수량 부족시 QuantityException 사용자 정의 예외 발생시킴
		
		book.setQuantity(res); 						// 판매후 남은 재고수량으로 재고 수량 변경
	}
	
	// 고유번호에 해당하는 도서를 수량만큼 구매 처리하여 재고를 증가시킨다-----------------------------------------------
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book book = searchByIsbn(isbn);						// 고유번호 도서 조회
		if(book == null) throw new ISBNNotFoundException(isbn); // 고유번호 도서 조회 실패시 ISBNNotFoundException 사용자 정의 예외 발생시킴
		
		book.setQuantity(book.getQuantity() + quantity);	// 구매 후의 새로운 재고 수량 계산하여 재고 수량 변경 
	}

	//추가 - 파일읽기------------------------------------------------------------------------
	private void loadData() {
		File f = new File("./book.dat");
		if(f.exists()) {	// 파일이 존재하면 파일에서 데이터 읽기
			// 파일에서 읽어오기 위해 FileInputStream을 생성 후 저장된 도서리스트 객체를 읽어오기 위해 ObjectInputStream을 생성한다.
			try(ObjectInputStream in  = new ObjectInputStream(new FileInputStream(f))){	
				books = (ArrayList<Book>) in.readObject();			// 도서리스트 객체를 파일에서 읽어오기			
			} catch (Exception e) {
				System.out.println("[SYSTEM]파일 읽기에 실패하였습니다.");
				e.printStackTrace();
			} 
		}else {				// 파일이 존재하지 않으면 새로운 리스트 생성
			books = new ArrayList<Book>();
		}
	}
	
	//도서리스트를 파일에 저장한다-----------------------------------------------------------------------
	@Override
	public void saveData() {
		// 파일에  저장하기 위해 FileOutputStream을 생성 후 도서리스트 객체를 저장하기 위해 ObjectOutputStream을 생성한다.
		try(ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream("book.dat"))){
			out.writeObject(books);	// 도서리스트 객체를 파일에 저장하기				
		} catch (Exception e) {
			System.out.println("[SYSTEM]파일 쓰기에 실패하였습니다.");
			e.printStackTrace();
		} 
	}
}
