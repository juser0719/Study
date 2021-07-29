package com.ssafy.hw07;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.hw07.Product;
import com.ssafy.hw07.Refrigerator;
import com.ssafy.hw07.TV;

public class ProductMgrlmpl implements IProductMgr {

	
	List<Product> pro = new ArrayList<>();
	
	public ProductMgrlmpl() {
		
	}
	
	@Override
	public void makeProduct() {
		pro.add(new TV("SAMSUNG",1234,1000,5,40));
		pro.add(new TV("LG",12345,500,30,100));
		pro.add(new Refrigerator("SAMSUNG",4321,100,3,400));
		pro.add(new Refrigerator("LG", 6542, 30, 3,300));
	}

	@Override
	public void Search() {
		// TODO Auto-generated method stub
		System.out.println("------------전체 검색-------------");
		for(Product p : pro) {
			System.out.println(p.toString());
		}
	}

	@Override
	public void Search(int num) {
		
		System.out.println("------------번호 검색-------------");
		for(Product p : pro) {
			if(p.getNumber() == num)
				System.out.println(p.toString());
		}
		
	}

	@Override
	public void Search(String name) {
		System.out.println("------------이름 검색-------------");
		for(Product p : pro) {
			if(p.getName().contains(name))
				System.out.println(p.toString());
		}
		
	}

	@Override
	public void SearchTV() {
		
		System.out.println("------------TV 검색-------------");
		for(Product p : pro) {
			if(p instanceof TV)
				System.out.println(p.toString());
		}
		
	}

	@Override
	public void SearchTV(int inch) {
		System.out.println("------------TV inch 검색-------------");
		for(Product p : pro) {
			if(p instanceof TV)
				if(((TV) p).getInch() >= inch)
					System.out.println(p.toString());
		}
		
	}

	@Override
	public void SearchRefrigerator() {
		System.out.println("------------Refrigerator 검색-------------");
		for(Product p : pro) {
			if(p instanceof Refrigerator)
				System.out.println(p.toString());
		}
		
	}

	@Override
	public void SearchRefrigerator(int l) {
		System.out.println("------------Refrigerator L 검색-------------");
		for(Product p : pro) {
			if(p instanceof Refrigerator)
				if(((Refrigerator) p).getL() >= l)
					System.out.println(p.toString());
		}
		
	}
	@Override
	public void Edit(int num, int price) {
		System.out.println("------------가격 수정-------------");
		for(Product p : pro) {
			if(p.getNumber() == num)
				p.setPrice(price);
		}
		
	}

	@Override
	public void DelProduct(int num) {
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

	@Override
	public void GetTotal() {
		System.out.println("------------총 금액-------------");
		int sum =0 ;
		
		for(Product p : pro) {
			sum += p.getPrice();
		}
		
		System.out.println(sum);
		
	}


}
