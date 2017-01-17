package com.buy.together.domain;

public class MyCriteria extends Criteria{

	private int user_number;
	private String searchType;
	private String keyword;
	
	public MyCriteria() {
		
	}
	
	public int getUser_number() {
		return user_number;
	}
	
	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return super.toString() + " SearchCriteria "
				+ "[searchType=" + searchType + ", keyword="
				+ keyword + "]";
	}
	   
}
