package com.otsi.retail.newSale.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "customer_details")
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CustomerDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long customer_id;

	private String name;

	private String mobileNumber;

	private String gstNumber;

	private String address;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate dob;

	private String gender;

	private String altMobileNo;
	
	@OneToMany(targetEntity = NewSaleEntity.class, mappedBy = "customerDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<NewSaleEntity> newsale;
	
	

}
