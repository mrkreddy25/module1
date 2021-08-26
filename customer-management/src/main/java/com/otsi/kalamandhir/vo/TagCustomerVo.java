/**
 * vo for TagCustomer
 */
package com.otsi.kalamandhir.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author vasavi
 *
 */
public class TagCustomerVo {

	private long id;

	private String billNo;

	private BarcodeVo barcodeVo;

	private String mobileNumber;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate fromDate;

	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate toDate;

	private StoreVo storeVo;

	private String reason;

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
	 * @return the barcodeVo
	 */

	/**
	 * @return the mobileNo
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @return the barcodeVo
	 */
	public BarcodeVo getBarcodeVo() {
		return barcodeVo;
	}

	/**
	 * @param barcodeVo the barcodeVo to set
	 */
	public void setBarcodeVo(BarcodeVo barcodeVo) {
		this.barcodeVo = barcodeVo;
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
	 * @return the storeVo
	 */
	public StoreVo getStoreVo() {
		return storeVo;
	}

	/**
	 * @param storeVo the storeVo to set
	 */
	public void setStoreVo(StoreVo storeVo) {
		this.storeVo = storeVo;
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

}
