package com.ssafy.happyhouse.model;

public class DongLocationDto {
	private double lng;
	private double lat;

	public DongLocationDto() {
		super();
	}

	public DongLocationDto(String lng, String lat) {
		super();
		this.lng = Double.parseDouble(lng);
		this.lat = Double.parseDouble(lat);
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

}
