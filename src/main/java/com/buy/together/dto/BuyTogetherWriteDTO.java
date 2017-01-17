package com.buy.together.dto;

import com.buy.together.domain.BuyTogether;
import com.buy.together.domain.BuyTogetherAddress;

public class BuyTogetherWriteDTO {
	
	private BuyTogether buytogether;
	private BuyTogetherAddress buytogetherAddress;
	
	public BuyTogether getBuytogether() {
		
		return buytogether;
	}
	
	public void setBuytogether(BuyTogether buytogether) {
		
		this.buytogether = buytogether;
	}

	public BuyTogetherAddress getBuytogetherAddress() {
		return buytogetherAddress;
	}

	public void setBuytogetherAddress(BuyTogetherAddress buytogetherAddress) {
		this.buytogetherAddress = buytogetherAddress;
	}
	
}
