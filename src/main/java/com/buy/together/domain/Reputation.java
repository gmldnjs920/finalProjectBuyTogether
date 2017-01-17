package com.buy.together.domain;

public class Reputation {

	private int user_number;
	private int joinUserNumber;
	private int MyBuyTogetherNumber;
	
	//dao 개설한 같이사냥, 참여한 같이사냥
	public Reputation(int user_number, int joinUserNumber, int myBuyTogetherNumber) {
		this.user_number = user_number;
		this.joinUserNumber = joinUserNumber;
		MyBuyTogetherNumber = myBuyTogetherNumber;
	}
	
	public int getUser_number() {
		return user_number;
	}
	
	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}
	
	public int getJoinUserNumber() {
		return joinUserNumber;
	}
	
	public void setJoinUserNumber(int joinUserNumber) {
		this.joinUserNumber = joinUserNumber;
	}
	
	public int getMyBuyTogetherNumber() {
		return MyBuyTogetherNumber;
	}
	
	public void setMyBuyTogetherNumber(int myBuyTogetherNumber) {
		MyBuyTogetherNumber = myBuyTogetherNumber;
	}
	
	
}
