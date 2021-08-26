/**
 * vo for Customer
 *
 */
package com.otsi.kalamandhir.vo;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CustomerVo {

	/**
	 * @author vasavi
	 *
	 */

	private long id;

	private String customerName;

	private String mobileNumber;

	private String gender;

	private String customerEmail;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateOfBirth;

	private String customerGstNo;

	private String address;

	private List<TagCustomerVo> tagCustomerVos;

	private String reason;

}
