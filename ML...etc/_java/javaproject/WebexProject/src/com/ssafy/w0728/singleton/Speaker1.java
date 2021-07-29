package com.ssafy.w0728.singleton;

public class Speaker1 {
	private int volume;
	
	public Speaker1 () {
		volume = 5;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "볼륨 : " + volume ;
	}
	
}
