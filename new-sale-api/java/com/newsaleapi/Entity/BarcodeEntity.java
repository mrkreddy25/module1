package com.newsaleapi.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "barcodes")
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class BarcodeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String barcode;

	private String itemDesc;

	private int qty;

	private Long mrp;

	private Long promoDisc;

	private Long netAmount;

	private Long salesMan;

	private LocalDateTime createdDate;

}
