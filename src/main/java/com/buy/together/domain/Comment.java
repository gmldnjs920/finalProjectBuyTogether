package com.buy.together.domain;

import java.util.Date;

public class Comment {

	private int comment_number;
	private String comment_content;
	private Date comment_writedate;
	private int buytogether_number;
	private int user_number;
	private String nickname;
	private int comment_type_number;
	private int comment_parent_number;

	public Comment() {

	}

	// 댓글 입력
	public Comment(String comment_content, int buytogether_number, int user_number, int comment_type_number) {
		
		this.comment_content = comment_content;
		this.buytogether_number = buytogether_number;
		this.user_number = user_number;
		this.comment_type_number = comment_type_number;
		
	}

	// 댓글 수정
	public Comment(String comment_content, int buytogether_number, int comment_number) {
		
		this.comment_content = comment_content;
		this.buytogether_number = buytogether_number;
		this.comment_number = comment_number;
		
	}

	// 답글 입력
	public Comment(int comment_parent_number, String comment_content, int buytogether_number, int user_number, int comment_type_number) {
		
		this.comment_parent_number = comment_parent_number;
		this.comment_content = comment_content;
		this.buytogether_number = buytogether_number;
		this.user_number = user_number;
		this.comment_type_number = comment_type_number;
		
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getComment_number() {
		return comment_number;
	}

	public void setComment_number(int comment_number) {
		this.comment_number = comment_number;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Date getComment_writedate() {
		return comment_writedate;
	}

	public void setComment_writedate(Date comment_writedate) {
		this.comment_writedate = comment_writedate;
	}

	public int getBuytogether_number() {
		return buytogether_number;
	}

	public void setBuytogether_number(int buytogether_number) {
		this.buytogether_number = buytogether_number;
	}

	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public int getComment_type_number() {
		return comment_type_number;
	}

	public void setComment_type_number(int comment_type_number) {
		this.comment_type_number = comment_type_number;
	}

	public int getComment_parent_number() {
		return comment_parent_number;
	}

	public void setComment_parent_number(int comment_parent_number) {
		this.comment_parent_number = comment_parent_number;
	}

}
