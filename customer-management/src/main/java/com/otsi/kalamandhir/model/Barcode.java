/**
 * Entity for Barcode
 */
package com.otsi.kalamandhir.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "barcode")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Barcode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author vasavi
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "barcode_id")
	private long barcodeId;
	@Column(name = "barcode")
	private String barcode;
	@Column(name = "invoice")
	private long invoice;
	@Column(name = "amount")
	private long amount;
	@Column(name = "quantity")
	private long quantity;
	@Column(name = "rtnQuantity")
	private long rtnQuantity;
	@Column(name = "reason")
	private String reason;
	@ManyToOne
	@JoinColumn(name = "rs_id")
	private listOfReturnSlipsModel returnSlips;

}
