package com.ssafy.hw07;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgrlmpl pr = new ProductMgrlmpl();
		
		pr.makeProduct();
		pr.Search();
		pr.Search(1234);
		pr.Search("SAMSUNG");
		pr.SearchTV();
		pr.SearchTV(50);
		pr.SearchRefrigerator();
		pr.SearchRefrigerator(400);
		pr.GetTotal();
		pr.Edit(1234, 99999);
		pr.GetTotal();
		pr.DelProduct(1234);
		pr.Search();
		
	}
}
