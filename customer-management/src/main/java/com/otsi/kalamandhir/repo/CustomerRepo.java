/**
 * Repo for Customer
 */
package com.otsi.kalamandhir.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.otsi.kalamandhir.model.Customer;
/**
 * @author vasavi
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	
	Optional<Customer> findByMobileNumber(String mobileNo);

	boolean existsByMobileNumber(String mobileNumber);

}
