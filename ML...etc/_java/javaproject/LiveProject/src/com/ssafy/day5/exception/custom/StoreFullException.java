package com.ssafy.day5.exception.custom;

public class StoreFullException extends RuntimeException{
	
	public StoreFullException() {
		super("창고가 꽉 찼습니다..!");
	}

}
