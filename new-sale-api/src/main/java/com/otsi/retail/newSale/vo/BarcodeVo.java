package com.otsi.retail.newSale.vo;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BarcodeVo {

	@NotBlank
	private String barcode;

	private String itemDesc;

	private int qty;

	private Long mrp;

	private Long promoDisc;

	private Long netAmount;

	private Long salesMan;

	private LocalDateTime createdDate;

	private LocalDateTime lastModified;

}
