package com.otsi.retail.newSale.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.otsi.retail.newSale.vo.CustomerDetails;


@Component
public interface CustomerService {

	ResponseEntity<?> saveCustomerDetails(CustomerDetails details) throws Exception;

	ResponseEntity<?> getCustomerByMobileNumber(String mobileNumber);

}

