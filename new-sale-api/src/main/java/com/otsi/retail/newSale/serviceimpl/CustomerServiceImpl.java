package com.otsi.retail.newSale.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.otsi.retail.newSale.Entity.CustomerDetailsEntity;
import com.otsi.retail.newSale.mapper.CustomerMapper;
import com.otsi.retail.newSale.repository.CustomerDetailsRepo;
import com.otsi.retail.newSale.service.CustomerService;
import com.otsi.retail.newSale.vo.CustomerDetails;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDetailsRepo customerRepo;

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public ResponseEntity<?> saveCustomerDetails(CustomerDetails details) {
		try {
			Optional<CustomerDetailsEntity> list = customerRepo.findByMobileNumber(details.getMobileNumber());

			if (!list.isPresent()) {

				CustomerDetailsEntity entity = customerMapper.convertVoToEntity(details);// mapper for VO to DTO
				customerRepo.save(entity);
				return new ResponseEntity<>("Customer details saved successfully..", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Mobile number is already in my records", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("error occurs while saving customer details", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> getCustomerByMobileNumber(String mobileNumber) {

		Optional<CustomerDetailsEntity> customerDetails = customerRepo.findByMobileNumber(mobileNumber);
		if (!customerDetails.isPresent()) {
			return new ResponseEntity<>(
					"Customer is with mobile number " + mobileNumber + " not exists. So please fill all the details..",
					HttpStatus.BAD_REQUEST);
		} else {
			CustomerDetails details = customerMapper.convertEntityToVo(customerDetails.get());
			return new ResponseEntity<>(details, HttpStatus.OK);

		}
	}

}
