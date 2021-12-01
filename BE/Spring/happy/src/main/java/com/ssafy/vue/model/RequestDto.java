package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RequestDto : 요청정보", description = "API 요청을 위한 Dto.")
public class RequestDto {
	
	@ApiModelProperty(value = "페이지번호")
	String pageNo;
	@ApiModelProperty(value = "한 페이지 결과 수 ex10")
	String numOfRows;
	@ApiModelProperty(value = "요청할 지역 ex11110")
	String lawdcd;
	@ApiModelProperty(value = "요청할 년월 ex 202110")
	String dealymd;
	
	@ApiModelProperty(value = "요청한 시도이름 ex 서울특별시")
	String sidoName;
	
	@ApiModelProperty(value = "요청한 구군이름 ex 종로구")
	String gugunName;
	
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(String numOfRows) {
		this.numOfRows = numOfRows;
	}
	public String getLawdcd() {
		return lawdcd;
	}
	public void setLawdcd(String lawdcd) {
		this.lawdcd = lawdcd;
	}
	public String getDealymd() {
		return dealymd;
	}
	public void setDealymd(String dealymd) {
		this.dealymd = dealymd;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	
}
