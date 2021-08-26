package com.otsi.retail.debitnotes.vo;

import java.util.List;

import lombok.Data;

@Data
public class NewSaleResponseVo {
	
private Long newsaleId;
	
	private Long customerId;
	
	private String customerName;
	
	private Long invoiceNumber;
	
	private Long amount;
	
	private List<PaymentAmountTypeVo> paymentAmountTypeId;
	
	private String mobileNumber;

}
