package com.buy.together.domain;

public class Access {

	private int access_number;
	private String access_name;
	private int access_declare_count;
	private int access_duedate;

	public Access() {

	}

	public int getAccess_number() {
		return access_number;
	}

	public void setAccess_number(int access_number) {
		this.access_number = access_number;
	}

	public String getAccess_name() {
		return access_name;
	}

	public void setAccess_name(String access_name) {
		this.access_name = access_name;
	}

	public int getAccess_declare_count() {
		return access_declare_count;
	}

	public void setAccess_declare_count(int access_declare_count) {
		this.access_declare_count = access_declare_count;
	}

	public int getAccess_duedate() {
		return access_duedate;
	}

	public void setAccess_duedate(int access_duedate) {
		this.access_duedate = access_duedate;
	}

}
