package com.ssafy.w0728.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListEx1 {
	
	public static void main(String[] args) {
		  List list=new ArrayList<>();
			list.add("one");
			list.add(2);
			list.add(new Float(3.0f));
			list.add(4.0f);
			list.add(3.0f); 
			list.add(new Integer(2));
			list.add(new Double(4.0));
	      System.out.println(list);
	      list.remove(new Integer(2));
	      
	      Iterator it = list.iterator();
	      while(it.hasNext()) {
	    	  System.out.println(it.next());
	      }
	}
}
