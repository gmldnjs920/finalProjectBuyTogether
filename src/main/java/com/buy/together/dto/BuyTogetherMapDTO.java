package com.buy.together.dto;

import java.util.List;

import com.buy.together.domain.AttachedPhoto;

public class BuyTogetherMapDTO {
	
	private int buytogether_number;
	private String title;
	private double longitude;
	private double latitude;
	private int category_number;
	private String nickname;
	private int reputation;
	private List<AttachedPhoto> photo_path;
	
	public BuyTogetherMapDTO() {
		
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

	public int getCategory_number() {
		return category_number;
	}

	public void setCategory_number(int category_number) {
		this.category_number = category_number;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public List<AttachedPhoto> getPhoto_path() {
		return photo_path;
	}

	public void setPhoto_path(List<AttachedPhoto> photo_path) {
		this.photo_path = photo_path;
	}
	
}
