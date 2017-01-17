package com.buy.together.dto;

public class LoginDTO { //같이사냥 회원 및 같이사냥 로그인을 위한 DTO
	
	private int user_number;
	private String id;
	private String pw;
	private String nickname;
	
	public LoginDTO() {

	}
	
	public LoginDTO(int user_number, String id, String pw) {
		this.user_number = user_number;
		this.id = id;
		this.pw = pw;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
