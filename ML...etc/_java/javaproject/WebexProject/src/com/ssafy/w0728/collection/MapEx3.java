package com.ssafy.w0728.collection;

import java.util.HashMap;
import java.util.Map;

public class MapEx3 {
	public static void main(String[] args) {
		Book ob1=new Book("java","kim",100);
	    Book ob2=new Book("c++","lee",250);
	    Book ob3=new Book("oracle","park",300);
	   
	   Map<String, Book> map = new HashMap<>();
	   
	   map.put(ob1.getTitle(),ob1 );
	   map.put(ob2.getTitle(),ob2 );
	   map.put(ob3.getTitle(),ob3 );
	   
	   
	   for(String s : map.keySet()) {
		   System.out.println(map.get(s).getAuthor());
	   }
	}
}
