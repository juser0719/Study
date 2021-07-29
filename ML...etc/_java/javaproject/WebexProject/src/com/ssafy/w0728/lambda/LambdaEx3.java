package com.ssafy.w0728.lambda;
@FunctionalInterface
interface Item {
	public String getItem();
}
public class LambdaEx3 {
	public static void main(String[] args) {
		
		Item m = new Item() {
			@Override
			public String getItem() {
				return "컴퓨터";
			};
		};
		
		System.out.println(m.getItem());
		
	}
	
}
