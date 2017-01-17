package com.buy.together.domain;

import java.util.Date;

public class Qna {

	private int qna_number;
	private String qna_title;
	private String qna_content;
	private Date qna_writedate;
	private int user_number;
	private int admin_number;

	public Qna() {

	}

	public int getQna_number() {
		return qna_number;
	}

	public void setQna_number(int qna_number) {
		this.qna_number = qna_number;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public Date getQna_writedate() {
		return qna_writedate;
	}

	public void setQna_writedate(Date qna_writedate) {
		this.qna_writedate = qna_writedate;
	}

	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public int getAdmin_number() {
		return admin_number;
	}

	public void setAdmin_number(int admin_number) {
		this.admin_number = admin_number;
	}

}
