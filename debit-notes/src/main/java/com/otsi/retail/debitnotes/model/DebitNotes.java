/**
 * entity for debitnotes
 */
package com.otsi.retail.debitnotes.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "debitnotes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitNotes implements Serializable{
	
	/**
	 * @author vasavi
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	private String drNo;

	private Long invoiceNumber;

	private String customerName;

	private Long amount;

	private String storeName;

	private LocalDate createdDate;
	
    private String authorisedBy;
	
	private String incharge;
	
	
	
	
}
