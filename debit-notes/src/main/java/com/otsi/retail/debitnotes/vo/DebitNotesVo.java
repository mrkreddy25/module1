package com.otsi.retail.debitnotes.vo;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class DebitNotesVo {

	private String drNo;

	private Long newsaleId;

	private Long invoiceNumber;

	private Long customerId;

	private String customerName;

	private Long amount;

	private List<PaymentAmountTypeVo> paymentAmountTypeId;

	private String storeName;

	private LocalDate createdDate;

	private String authorisedBy;

	private String incharge;

}
