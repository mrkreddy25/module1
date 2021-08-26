package com.otsi.retail.debitnotes.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.otsi.retail.debitnotes.common.PaymentType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentAmountTypeVo {

	private Long id;

	private PaymentType paymentType;

	private Long paymentAmount;

	//private NewSaleVo newsale;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the paymentType
	 */
	public PaymentType getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the paymentAmount
	 */
	public Long getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(Long paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	
}

