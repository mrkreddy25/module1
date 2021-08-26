package com.otsi.retail.debitnotes.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.otsi.retail.debitnotes.vo.CustomerVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class NewSaleEntity {
 
	private Long newsaleId;

	//private String custmerId;

	private Long grossAmount;

	private Long totalPromoDisc;

	private Long totalManualDisc;

	private float roundOff;

	private Long netPayableAmount;

	private Long taxAmount;

	private String billNumber;
    
	private String biller;
	
	private String billStatus;
	
	private Long invoiceNumber;

	private LocalDate createdDate;
	
	private Long offlineNumber;
	
	private String approvedBy;
	
	private String reason;

	
	private List<DeliverySlip> dlSlip;

	
	private CustomerVo customerDetails;
	
	
	private List<PaymentAmountType> paymentType;
	@OneToOne
	private DebitNotes debitNotes;
}
