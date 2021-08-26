package com.otsi.retail.debitnotes.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
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
