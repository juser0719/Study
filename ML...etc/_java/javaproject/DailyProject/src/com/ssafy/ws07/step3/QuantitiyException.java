package com.ssafy.ws07.step3;

public class QuantitiyException extends Exception{
	public QuantitiyException () {
		super("수량이 부족합니다.");
	}
}
