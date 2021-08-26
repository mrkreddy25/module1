package com.otsi.retail.debitnotes.common;

import java.io.Serializable;

public enum PaymentType implements Serializable {

	Cash(1, "Cash"), Card(2, "Card"), RTSlip(3, "RTSlip"), PKTPENDING(4, "PKTPENDING"), PKTADVANCE(5, "PKTADVANCE"),
	PHRGVS(6, "PHRGVS"), LoyaltyPoint(7, "LoyaltyPoint"), OtherPayments(8, "OtherPayments"), GETQRCODE(9, "GETQRCODE"),
	UPI(10, "UPI");
	
	private int num;

	private String type;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private PaymentType(int num, String type) {

		this.num = num;
		this.type = type;

	}

}

