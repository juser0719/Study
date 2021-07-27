package com.ssafy.hw06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductMgr {

	List<Product> pro = new ArrayList<>();
	
			
//			Arrays.asList(new TV("SAMSUNG",1234,1000,5), new TV("LG",12345,500,30),new Refrigerator("SAMSUNG",4321,100,3),new Refrigerator("LG", 6542, 30, 3));
	
	
	public ProductMgr() {
	}
	
	public void makeProduct() {
		pro.add(new TV("SAMSUNG",1234,1000,5));
		pro.add(new TV("LG",12345,500,30));
		pro.add(new Refrigerator("SAMSUNG",4321,100,3));
		pro.add(new Refrigerator("LG", 6542, 30, 3));
	}
	
	public void Search () {
		System.out.println("------------전체 검색-------------");
		for(Product p : pro) {
			System.out.println(p.toString());
		}
	}
	
	public void Search (String name) {
		System.out.println("------------이름 검색-------------");
		for(Product p : pro) {
			if(p.getName().contains(name))
				System.out.println(p.toString());
		}
	}
	
	public void Search (int num) {
		System.out.println("------------번호 검색-------------");
			for(Product p : pro) {
				if(p.getNumber() == num)
					System.out.println(p.toString());
		}
	}
	
	public void SearchTV() {
		System.out.println("------------TV 검색-------------");
		for(Product p : pro) {
			if(p instanceof TV)
				System.out.println(p.toString());
		}
	}

	public void SearchRefrigerator() {
		System.out.println("------------Ref 검색-------------");
		for(Product p : pro) {
			if(p instanceof Refrigerator)
				System.out.println(p.toString());
		}
	}
	
	public void getAllPrice() {
		System.out.println("------------총 금액-------------");
		int sum =0 ;
		
		for(Product p : pro) {
			sum += p.getPrice();
		}
		
		System.out.println(sum);
	}
	
	public void delProduct(int num) {
		int idx = 0;
		
		for(int i = 0; i < pro.size() ; i++) {
			
			if(pro.get(i).getNumber() == num)
			{
				idx = i;
			}
		}

		try {
			pro.remove(idx);
			System.out.println("------------삭제 완료-------------");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("삭제할 제품의 번호를 다시 확인해주세요!!");
		}
	}
	
}
