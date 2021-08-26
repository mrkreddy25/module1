/**
 * Entity for Store
 */
package com.otsi.kalamandhir.model;

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
@Table(name = "storess")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
	/**
	 * @author vasavi
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private long id;
    @Column(name = "store_name")
	private String storeName;
  

}
