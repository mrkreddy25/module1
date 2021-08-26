package com.newsaleapi.vo;

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

}
