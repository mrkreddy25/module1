package com.otsi.retail.newSale.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "barcodes")
public class BarcodeEntity {

	@Id
	@GeneratedValue
	private Long barcodeId;
	
	private String barcode;

	private String itemDesc;

	private int qty;

	private Long mrp;

	private Long promoDisc;

	private Long netAmount;

	private Long salesMan;

	private LocalDateTime createdDate;

	private LocalDateTime lastModified;
	
	@ManyToOne
	@JoinColumn(name = "ds_id")
	private DeliverySlipEntity deliverySlip;

	/*
	 * @ManyToOne // @JoinColumn(name = "ds_id") private DeliverySlipEntity
	 * delivery_slip;
	 */

}
