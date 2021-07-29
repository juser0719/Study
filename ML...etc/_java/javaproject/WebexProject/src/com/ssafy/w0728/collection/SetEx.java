package com.ssafy.w0728.collection;

import java.util.*;

public class SetEx {
	public static void main(String[] args) {
		  Set set=new HashSet();
	      set.add("one");
	      set.add(2);
	      set.add(new Float(3.0f));
	      set.add(4.0f);
	      set.add(3.0f); 
	      set.add(new Integer(2));
	      set.add(new Double(4.0));
	      System.out.println(set);
	}
}
