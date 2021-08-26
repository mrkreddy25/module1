/**
 * Entity for Customer
 */
package com.otsi.kalamandhir.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

	/**
	 * @author vasavi
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private long id;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "gender")
	private String gender;
	@Column(name = "customer_email")
	private String customerEmail;
	@Column(name = "date_of_birth")
	// @DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateOfBirth;
	@Column(name = "customer_gst_no")
	private String customerGstNo;
	@Column(name = "address")
	private String address;

}
