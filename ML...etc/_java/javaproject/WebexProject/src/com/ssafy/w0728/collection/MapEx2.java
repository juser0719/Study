package com.ssafy.w0728.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapEx2 {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("ddd", "gi");
		map.put("bbb", "Not Found");
		map.put("aaa", "hi");
		
		System.out.println(map);
		Set<String> keys = map.keySet();
		List<String> list= new ArrayList<>(keys);
		Collections.sort(list);
		for(String k : keys) {
			System.out.println(map.get(k));
		}
	}
}
