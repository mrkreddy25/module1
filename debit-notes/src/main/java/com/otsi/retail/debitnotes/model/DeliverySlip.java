package com.otsi.retail.debitnotes.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliverySlip {
	
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

	
	

	

}
