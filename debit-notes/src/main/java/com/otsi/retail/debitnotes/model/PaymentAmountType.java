/**
 * 
 */
package com.otsi.retail.debitnotes.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.otsi.retail.debitnotes.common.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ADMIN
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAmountType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private PaymentType paymentType;

	private Long paymentAmount;

	@ManyToOne
	@JoinColumn(name = "newsale_id")
	private NewSaleEntity newsaleId;
	

}

