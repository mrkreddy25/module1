package com.otsi.retail.debitnotes.vo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class CustomerVo {

	private Long customerId;

	private String name;

	private String mobileNumber;

	private String gstNumber;

	private String address;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate dob;

	private String gender;

	private String altMobileNo;

}
