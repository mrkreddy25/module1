package com.otsi.retail.newSale.vo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ListOfSaleBillsVo {

	private String dsNumber;

	private String barcode;

	private LocalDate dateFrom;

	private LocalDate dateTo;

	private LocalDate createdDate;
	
	private String billStatus;

	private String custMobileNumber;

	private Long invoiceNumber;

	private String billNumber;
	private Long amount;
	
	private List<NewSaleVo> newSaleVo;
	
	
 
}
