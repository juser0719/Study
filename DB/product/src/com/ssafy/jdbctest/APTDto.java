package com.ssafy.jdbctest;

/**
 * @author jeon-ungjae
 *
 */
public class APTDto {
	private String sido,gu,dong;
	private String name;
	private int price;
	
	@Override
	public String toString() {
		return "APTDto [sido=" + sido + ", gu=" + gu + ", dong=" + dong + ", name=" + name + ", price=" + price + "]";
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
