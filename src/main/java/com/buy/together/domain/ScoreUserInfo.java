package com.buy.together.domain;

public class ScoreUserInfo {

	private int scored_user_number;
	private int score;
	private int score_user_number;
	private int buyTogetherNumber;
	
	
	public ScoreUserInfo() {
		
	}

	//service 평판매기기
	public ScoreUserInfo(int scored_user_number, int score, int score_user_number, int buyTogetherNumber) {
		this.scored_user_number = scored_user_number;
		this.score = score;
		this.score_user_number = score_user_number;
		this.buyTogetherNumber = buyTogetherNumber;
	}
	
	//dao 평판 기록 남기기
	public ScoreUserInfo(int scored_user_number, int score_user_number, int buyTogetherNumber) {
		this.scored_user_number = scored_user_number;
		this.score_user_number = score_user_number;
		this.buyTogetherNumber = buyTogetherNumber;
	}
	
	//dao 평판 점수 주기
	public ScoreUserInfo(int scored_user_number, int score) {
		super();
		this.scored_user_number = scored_user_number;
		this.score = score;
	}
	
	public int getScored_user_number() {
		return scored_user_number;
	}
	
	public void setScored_user_number(int scored_user_number) {
		this.scored_user_number = scored_user_number;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore_user_number() {
		return score_user_number;
	}
	
	public void setScore_user_number(int score_user_number) {
		this.score_user_number = score_user_number;
	}
	
	public int getBuyTogetherNumber() {
		return buyTogetherNumber;
	}
	
	public void setBuyTogetherNumber(int buyTogetherNumber) {
		this.buyTogetherNumber = buyTogetherNumber;
	}

	
	
}
