/**
 * Entity for tagCustomer
 */
package com.otsi.kalamandhir.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tag_customer")

public class TagCustomer implements Serializable {
	/**
	 * @author vasavi
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "bill_no")
	private String billNo;
	@OneToOne
	@JoinColumn(name = "barcode_id")
	private Barcode barcode;
	@Column(name = "mobile_no")
	private String mobileNumber;
	@Column(name = "from_date")
	private LocalDate fromDate;
	@Column(name = "to_date")
	private LocalDate toDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store", referencedColumnName = "store_id", nullable = false)
	private Store stores;
	@Column(name = "reason")
	private String reason;

	public TagCustomer() {
		super();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the billNo
	 */
	public String getBillNo() {
		return billNo;
	}

	/**
	 * @param billNo the billNo to set
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the fromDate
	 */
	public LocalDate getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public LocalDate getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the barcode
	 */
	public Barcode getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(Barcode barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the stores
	 */
	public Store getStores() {
		return stores;
	}

	/**
	 * @param stores the stores to set
	 */
	public void setStores(Store stores) {
		this.stores = stores;
	}

}
