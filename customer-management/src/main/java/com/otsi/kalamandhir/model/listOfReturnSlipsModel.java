package com.otsi.kalamandhir.model;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lakshmi
 *
 */
@Entity
@Table(name = "returnSlips")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class listOfReturnSlipsModel {

	@Id
	@GeneratedValue
	private int rsId;

	private LocalDate createdInfo;

	private String rtNumber;

	private String crNo;

	private String settelmentInfo;
	private String creditNote;

	private String rtReviewStatus;
	private String rtStatus;

	@OneToMany(targetEntity = Barcode.class, mappedBy = "returnSlips", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Barcode> barcode;

}
