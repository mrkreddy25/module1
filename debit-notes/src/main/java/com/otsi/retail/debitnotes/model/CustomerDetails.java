package com.otsi.retail.debitnotes.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {
	
	private Long customerId;

	private String name;

	private String mobileNumber;

	private String gstNumber;

	private String address;

	
	private LocalDate dob;

	private String gender;

	private String altMobileNo;

}
