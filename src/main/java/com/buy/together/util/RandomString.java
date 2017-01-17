package com.buy.together.util;

import java.util.Random;
//import java.util.Random 클래스를 이용한 임의의 문자열 만들기
public class RandomString {
	public String RandomPass(){

		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		String result = "";

		for(int i = 0; i < 8; i++) {
			if(random.nextBoolean()) {
				buffer.append((char)((int)(random.nextInt(26))+97));
			} else {
				buffer.append((random.nextInt(10)));
			}
		}
		
		System.out.println(buffer);
		result = String.valueOf(buffer);
		return result;
	}
}

/*random.nextBoolean()은 랜덤으로 true, false를 리턴하는데
true일 경우 랜덤으로 한 소문자를 buffer에 append를 하고,
false일 경우 랜덤으로 0부터 9까지 한 숫자를 buffer에 append합니다.*/
 