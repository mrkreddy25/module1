package com.otsi.retail.debitnotes.vo;

import java.time.LocalDate;
import java.util.List;

import com.otsi.retail.debitnotes.common.SaleNature;
import com.otsi.retail.debitnotes.model.CustomerDetails;
import com.otsi.retail.debitnotes.model.DebitNotes;
import com.otsi.retail.debitnotes.model.DeliverySlip;
import com.otsi.retail.debitnotes.model.PaymentAmountType;

import lombok.Data;
@Data
public class NewSaleVo {
	
	private Long newsaleId;

	//private String custmerId;
	
	private SaleNature natureOfSale;

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

	
	private CustomerDetails customerDetails;
	
	private List<PaymentAmountType> paymentType;

	private DebitNotesVo debitNotes;

	

}
