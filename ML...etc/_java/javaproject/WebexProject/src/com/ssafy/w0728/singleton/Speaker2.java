package com.ssafy.w0728.singleton;

public class Speaker2 {
	private static Speaker2 speaker;
	private int volume;
	
	
	public Speaker2() {
		super();
	}
	public static Speaker2 getSpeaker() {
		if(speaker == null)
			speaker = new Speaker2();
		return speaker;
	}
	public static void setSpeaker(Speaker2 speaker) {
		Speaker2.speaker = speaker;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
}
