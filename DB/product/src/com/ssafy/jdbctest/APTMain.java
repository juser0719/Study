package com.ssafy.jdbctest;
import java.io.*;
import java.util.List;

public class APTMain {
	
	BufferedReader in;

	public APTMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		new APTMain().menu();
	}

	private void menu() {
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("*************** 메뉴 선택 ***************");
			System.out.println("1. 둘러 보기");
			System.out.println("2. 관심 지역 등록");
			System.out.println("3. 관심 지역 둘러보기");
			System.out.println("4. 로그인");
			System.out.println("5. 회원가입");
			System.out.println("6. 관리자 페이");
			System.out.println("0. 종료");
			System.out.println("******************************************");
			System.out.print("번호 입력 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch(num) {
				case 1 : lookAround();break;
//				case 2 : updatePrice();break;
//				case 3 : deleteProduct();break;
//				case 4 : searchById();break;
//				case 5 : searchByPrice();break;
//				case 6 : searchAll();break;
				default : isContinue = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("@@@@@@@@@@@ 프로그램 종료 @@@@@@@@@@@");
	}
	
	
	
	private void lookAround() {
		
		System.out.println("--------------------- 위치 선택 ---------------------");
		List<String> gu = APTDaoImpl.getAPTDao().searchLoc();
		
	}
	
//
//	private void updatePrice() {
////		System.out.println("updatePrice");
//		try {
//			System.out.println("--------------------- 상품 가격 변경 ---------------------");
//			System.out.print("변경할 상품 아이디 : ");
//			String productId = in.readLine();
//			System.out.print("변경할 상품 가격 : ");
//			int productPrice = Integer.parseInt(in.readLine());
//			
//			APTDaoImpl.getAPTDao().updatePrice(productId, productPrice);
//			System.out.println("-------------------------------------------------");
//			System.out.println("상품 가격 변경 성공!!!!!");
//			System.out.println("-------------------------------------------------");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void deleteProduct() {
////		System.out.println("deleteProduct");
//		try {
//			System.out.println("--------------------- 상품 삭제 ---------------------");
//			System.out.print("삭제할 상품 아이디 : ");
//			String productId = in.readLine();
//			
//			APTDaoImpl.getAPTDao().deleteProduct(productId);
//			System.out.println("-------------------------------------------------");
//			System.out.println("상품 삭제 성공!!!!!");
//			System.out.println("-------------------------------------------------");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void searchById() {
////		System.out.println("searchById");
//		try {
//			System.out.print("변경할 상품 아이디 : ");
//			String productId = in.readLine();
//			APTDaoImpl productDto = APTDaoImpl.getAPTDao().searchById(productId);
//			showProduct(productDto);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void searchByPrice() {
////		System.out.println("searchByPrice");
//		try {
//			System.out.print("검색할 상품 가격(최저가) : ");
//			int productPrice = Integer.parseInt(in.readLine());
//			List<ProductDto> list = APTDaoImpl.getAPTDao().searchByPrice(productPrice);
//			showList(list);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void searchAll() {
////		System.out.println("searchAll");
//		List<ProductDto> list = APTDaoImpl.getAPTDao().searchAll();
//		showList(list);
//	}
//
//	private void showProduct(ProductDto productDto) {
//		if(productDto != null) {
//			System.out.println("============ 상품 정보 ============");
//			System.out.println("상품 아이디 : " + productDto.getProductId());
//			System.out.println("상품 이름 : " + productDto.getProductName());
//			System.out.println("상품 가격 : " + productDto.getProductPrice() + "원");
//			System.out.println("상품 설명 : " + productDto.getProductDesc());
//			System.out.println("상품 등록일 : " + productDto.getRegisterDate());
//			System.out.println("-------------------------------------------------");
//		} else {
//			System.out.println("-------------------------------------------------");
//			System.out.println("상품이 존재하지 않습니다.");
//			System.out.println("-------------------------------------------------");
//		}
//	}
//	
//	private void showList(List<ProductDto> list) {
//		System.out.println("===================================== 상품 목록 =====================================");
//		System.out.println("상품아이디\t상품이름\t상품가격\t등록일\t\t상품설명");
//		System.out.println("-------------------------------------------------------------------------------------");
//		for(ProductDto productDto : list) {
//			System.out.println(productDto);
//		}
//		System.out.println("-------------------------------------------------------------------------------------");
//	}
//}
