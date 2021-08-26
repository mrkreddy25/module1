package com.otsi.retail.newSale.vo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.otsi.retail.newSale.common.PaymentType;
import com.otsi.retail.newSale.common.SaleNature;

import lombok.Data;

@Data
@Component
public class NewSaleVo {

	private CustomerDetails customerDetails;

	private SaleNature natureOfSale;
    
	private Long invoiceNumber;
	
	private String biller;

	private PaymentType payType;

	private String custmerId;

	private Long grossAmount;

	private Long totalPromoDisc;

	private Long totalManualDisc;

	private float roundOff;

	private Long netPayableAmount;
	
	private LocalDate createdDate;

	private Long taxAmount;
    
	private Long offlineNumber;
	
	private String approvedBy;
	
	private String reason;

	private List<DeliverySlipVo> dlSlip;

}
