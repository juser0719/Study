package com.ssafy.jdbctest;

import java.util.List;

public interface APTDao {
	List<String> searchLoc();
	APTDto searchAPT(int no); // 
	List<APTDto> searchAPTs(); //all
	List<APTDto> favoriteDong(String[] dong); // 관심동기준.
	
}
