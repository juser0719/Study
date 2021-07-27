package com.ssafy.hw06;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr pr = new ProductMgr();
		pr.makeProduct();
		pr.Search();
		pr.Search(1234);
		pr.Search("SAMSUNG");
		pr.SearchTV();
		pr.SearchRefrigerator();
		pr.getAllPrice();
		pr.delProduct(1234);
		pr.Search();
	}
}
