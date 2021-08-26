package com.newsaleapi.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CustomerDetails {

	@Pattern(regexp = "[a-zA-Z]+")
	@NotBlank(message = "Name must be filled")
	private String name;

	@Size(min = 10, max = 11, message = "mobile number must be filled and it is in between {min} and {max} letters")
	@Pattern(regexp = "[0-9]+")
	@NotBlank(message = "Mobile number should not be null/empty")
	private String mobileNumber;

	private String gstNumber;

	private String address;

	// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate dob;

	@NotBlank(message = "Gender must be filled")
	@Pattern(regexp = "[a-zA-Z]+")
	private String gender;

	@Size(min = 10, max = 11)
	private String altMobileNo;

}
