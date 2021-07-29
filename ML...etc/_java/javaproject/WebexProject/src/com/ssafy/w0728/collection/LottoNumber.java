package com.ssafy.w0728.collection;

import java.util.*;

/*
 * 5개 만들기 - 숫자 겹치기X , 오름차순 정
 * */

public class LottoNumber {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size() != 5)
		{
			set.add((int)(Math.random()*46 + 1));
		}
		
		List<Integer> li = new ArrayList<>(set);
		Collections.sort(li);
		for(int i : li) 
		{
			System.out.println(i);
		}
	}
}
