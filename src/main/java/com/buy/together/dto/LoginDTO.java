package com.buy.together.dto;

public class LoginDTO { //같이사냥 회원 및 같이사냥 로그인을 위한 DTO
	
	private int user_number;
	private String email;
	private String pw;
	private String nickname;
	private int level_number;
	
	public LoginDTO() {

	}
	
	public LoginDTO(int user_number, String email, String pw, int level_number, String nickname) {
		this.user_number = user_number;
		this.email = email;
		this.pw = pw;
		this.level_number = level_number;
		this.nickname = nickname;
	}

	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getLevel_number() {
		return level_number;
	}

	public void setLevel_number(int level_number) {
		this.level_number = level_number;
	}
	
}
