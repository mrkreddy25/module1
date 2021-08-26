package com.otsi.retail.newSale.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.otsi.retail.newSale.common.DSStatus;

import lombok.Data;

@Component
@Data
public class DeliverySlipVo {

	private List<BarcodeVo> barcode;

	private int qty;
	
	private String dsNumber;

	private String type;

	private Long mrp;

	private Long promoDisc;

	private Long netAmount;

	private DSStatus status;

	private Long salesMan;

	private LocalDate createdDate;

	private LocalDateTime lastModified;

	// private Long salesMan;

	// private String barcodes;

}
