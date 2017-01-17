package com.buy.together.dto;

public class BuyTogetherUpdateDTO {

	private int buytogether_number;
	private String title;
	private String content;
	private String duedate;
	private int join_number;
	private int price;
	private int category_number;
	private int hunting_type_number;
	private int user_number;
	private String[] path;
	private double longitude;
	private double latitude;
	private String buytogether_address_sido;
	private String buytogether_address_sigungu;
	private String buytogether_address_road_address;
	private String buytogether_address_detail;
	
	public BuyTogetherUpdateDTO() {
		
	}

	public int getBuytogether_number() {
		return buytogether_number;
	}

	public void setBuytogether_number(int buytogether_number) {
		this.buytogether_number = buytogether_number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public int getJoin_number() {
		return join_number;
	}

	public void setJoin_number(int join_number) {
		this.join_number = join_number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategory_number() {
		return category_number;
	}

	public void setCategory_number(int category_number) {
		this.category_number = category_number;
	}

	public int getHunting_type_number() {
		return hunting_type_number;
	}

	public void setHunting_type_number(int hunting_type_number) {
		this.hunting_type_number = hunting_type_number;
	}
	
	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public String[] getPath() {
		return path;
	}

	public void setPath(String[] path) {
		this.path = path;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public String getBuytogether_address_sido() {
		return buytogether_address_sido;
	}

	public void setBuytogether_address_sido(String buytogether_address_sido) {
		this.buytogether_address_sido = buytogether_address_sido;
	}

	public String getBuytogether_address_sigungu() {
		return buytogether_address_sigungu;
	}

	public void setBuytogether_address_sigungu(String buytogether_address_sigungu) {
		this.buytogether_address_sigungu = buytogether_address_sigungu;
	}

	public String getBuytogether_address_road_address() {
		return buytogether_address_road_address;
	}

	public void setBuytogether_address_road_address(String buytogether_address_road_address) {
		this.buytogether_address_road_address = buytogether_address_road_address;
	}

	public String getBuytogether_address_detail() {
		return buytogether_address_detail;
	}

	public void setBuytogether_address_detail(String buytogether_address_detail) {
		this.buytogether_address_detail = buytogether_address_detail;
	}

}
