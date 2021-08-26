/**
 * vo for SearchFilter
 */
package com.otsi.kalamandhir.vo;

import java.time.LocalDate;

/**
 * @author vasavi
 *
 */
public class SearchFilterVo {

	private long id;

	private String billNo;

	private long barcodeVo;

	private String mobileNo;

	private LocalDate fromDate;

	private LocalDate toDate;

	private long storeVo;

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
	public long getBarcodeVo() {
		return barcodeVo;
	}

	/**
	 * @param barcodeVo the barcodeVo to set
	 */
	public void setBarcodeVo(long barcodeVo) {
		this.barcodeVo = barcodeVo;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
	public long getStoreVo() {
		return storeVo;
	}

	/**
	 * @param storeVo the storeVo to set
	 */
	public void setStoreVo(long storeVo) {
		this.storeVo = storeVo;
	}

	/**
	 * @return the storeVo
	 */

}
