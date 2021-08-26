package com.otsi.retail.debitnotes.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliverySlipVo {

	private Long dsId;

	private String dsNumber;
	
	private int qty;

	private String type;

	private Long mrp;

	private Long promoDisc;

	private Long netAmount;
	
	private Long salesMan;

	private LocalDate createdDate;

	private LocalDateTime lastModified;

	
	//private List<Barcode> barcodes;

}
