package com.ssafy.hw07;

interface IProductMgr {
	public void makeProduct();
	public void Search ();
	public void Search (int num);
	public void Search (String name);
	public void SearchTV();
	public void SearchTV(int inch);
	public void SearchRefrigerator();
	public void SearchRefrigerator(int l);
	public void Edit(int num , int price);
	public void DelProduct(int num);
	public void GetTotal();

}
