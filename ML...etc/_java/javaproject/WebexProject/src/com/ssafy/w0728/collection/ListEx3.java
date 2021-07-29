package com.ssafy.w0728.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListEx3 {
	public static void main(String[] args) {
		Book ob1=new Book("java","kim",100);
	    Book ob2=new Book("c++","lee",250);
	    Book ob3=new Book("oracle","park",300);
	    
	    List<Book> list = new ArrayList<>();
	    list.add(ob1);
	    list.add(ob2);
	    list.add(ob3);
	    
	    Iterator<Book> it = list.iterator();
	    
	    while(it.hasNext()) {
	    	Book ob = it.next();
	    	System.out.println(ob.getTitle());
	    	System.out.println(ob.getAuthor());
	    	System.out.println(ob.getPage());
	    }
	}
}
