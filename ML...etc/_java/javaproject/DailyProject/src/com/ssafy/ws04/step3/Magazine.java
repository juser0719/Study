package com.ssafy.ws04.step3;

public class Magazine {
	private int year;
	private int month;
	
	public Magazine() {
		super();
	}
	public Magazine(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	@Override
   public String toString() {
      StringBuilder builder=new StringBuilder();
      builder.append(super.toString());
      builder.append("|");
      builder.append(year+"\t|");
      builder.append(month);
      return builder.toString();
	}
	
	
}
