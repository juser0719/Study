package com.ssafy.w0720.object;


class UserInfo {
	public String name;
	public String addr;
	
	public UserInfo() {
		
	}
	public UserInfo(String name  , String addr) {
		this.name = name;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	
}

public class ConstructorEx3 {
	public static void main(String[] args) {
		UserInfo ob = new UserInfo("도라에몽","광주광역시 광산구 흑석동 ");
		System.out.printf("이름 : %s%n주소 : %s",ob.getName(),ob.getAddr());
	}
}
