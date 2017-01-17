package com.buy.together.domain;

public class MyBound {
	
	private double swLng;
	private double swLat;
	private double neLng;
	private double neLat;
	
	public MyBound() {
		
	}
	
	public MyBound(double swLng, double swLat, double neLng, double neLat) {
		this.swLng = swLng;
		this.swLat = swLat;
		this.neLng = neLng;
		this.neLat = neLat;
	}

	public double getSwLng() {
		return swLng;
	}

	public void setSwLng(double swLng) {
		this.swLng = swLng;
	}

	public double getSwLat() {
		return swLat;
	}

	public void setSwLat(double swLat) {
		this.swLat = swLat;
	}

	public double getNeLng() {
		return neLng;
	}

	public void setNeLng(double neLng) {
		this.neLng = neLng;
	}

	public double getNeLat() {
		return neLat;
	}

	public void setNeLat(double neLat) {
		this.neLat = neLat;
	}
	
}
