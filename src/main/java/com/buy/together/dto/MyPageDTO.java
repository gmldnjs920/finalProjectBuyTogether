package com.buy.together.dto;

import java.util.Date;
import java.util.List;

public class MyPageDTO {
	
	private int user_number;
	private String id;
	private String name;
	private String email;
	private String phone_number;
	private Date birthdate;
	private String gender;
	private String nickname;
	private String region;
	private int reputation;
	private List<Integer> category_number;
	private int interest;
	private String user_sido;
	private String user_sigungu;
	
	public MyPageDTO() {

	}
	
	public int getUser_number() {
		return user_number;
	}
	
	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	public int getReputation() {
		return reputation;
	}
	
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	
	public List<Integer> getCategory_number() {
		return category_number;
	}
	public void setCategory_number(List<Integer> category_number) {
		this.category_number = category_number;
	}
	
	public String getUser_sido() {
		return user_sido;
	}
	
	public void setUser_sido(String user_sido) {
		this.user_sido = user_sido;
	}
	
	public String getUser_sigungu() {
		return user_sigungu;
	}
	
	public void setUser_sigungu(String user_sigungu) {
		this.user_sigungu = user_sigungu;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}
	
}
