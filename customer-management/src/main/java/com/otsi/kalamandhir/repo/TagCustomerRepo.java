/**
 * Repo for TagCustomer
 */
package com.otsi.kalamandhir.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.kalamandhir.model.TagCustomer;

/**
 * @author vasavi
 */
@Repository
public interface TagCustomerRepo extends JpaRepository<TagCustomer, Long> {

	List<TagCustomer> findByMobileNumberOrBillNoOrBarcodeBarcodeId(String mobileNo, String billNo, long barcodeVo);

}
