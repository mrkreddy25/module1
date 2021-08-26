/**
 * controller for generateReturnSlip,searchFilterbyName,getListOfReturnSlips
 */
package com.otsi.kalamandhir.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.kalamandhir.gatewayresponse.GateWayResponse;
import com.otsi.kalamandhir.service.CustomerService;
import com.otsi.kalamandhir.vo.CustomerVo;
import com.otsi.kalamandhir.vo.ListOfReturnSlipsVo;
import com.otsi.kalamandhir.vo.SearchFilterVo;

@RestController

@RequestMapping("/customer")
public class CustomerController {

	private Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * save functionality through service
	 */
	@PostMapping("/saveCustomer")
	public GateWayResponse<?> saveCustomer(@RequestBody CustomerVo vo) {
		log.info("Received Request to add new customer: " + vo);
		try {
			vo = customerService.saveCustomer(vo);
			// if vo is null,it will print failure message.Otherwise,it will save customer
			if (vo == null) {
				return new GateWayResponse<>(false, HttpStatus.OK, "Customer not saved!", "Failure");
			}
			return new GateWayResponse<>(HttpStatus.OK, vo, "Success");
		} catch (Exception ex) {
			return new GateWayResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	/**
	 * generateReturnSlip functionality through service
	 */
	@PostMapping("/generateReturnSlip")
	public GateWayResponse<?> generateReturnSlip(@RequestBody CustomerVo vo) {
		log.info("Received Request to add new customer: " + vo);

		try {
			vo = customerService.generateReturnSlip(vo);
			// if vo is null,it will print failure message.Otherwise,it will generate slip
			if (vo == null) {
				return new GateWayResponse<>(false, HttpStatus.OK, "Customer Return Slip not saved!", "Failure");
			}
			return new GateWayResponse<>(HttpStatus.OK, vo, "Success");
		} catch (Exception ex) {
			return new GateWayResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	/**
	 * searchFilterbyName functionality through service
	 */
	@PostMapping("/searchFilterbyName")
	public GateWayResponse<?> searchFilterbyName(@RequestBody SearchFilterVo vo) {
		log.info("Received request to search filter:" + vo);
		return new GateWayResponse<CustomerVo>(customerService.searchbyName(vo));

	}
	/**
	 * getListOfReturnSlips functionality through service
	 */
	@PostMapping("/getListOfReturnSlips")
	public GateWayResponse<?> getListOfReturnSlips(@RequestBody ListOfReturnSlipsVo vo) {
		log.info("Received request to getListOfReturnSlips:" + vo);
		List<ListOfReturnSlipsVo> listVo=null;

		try {
			listVo = customerService.getListOfReturnSlips(vo);
			// if vo is null,it will print failure message.Otherwise,it will give the details;
			if (listVo == null) {
				return new GateWayResponse<>(false, HttpStatus.OK, "no record found with the given information", "Failure");
			}
			return new GateWayResponse<>(HttpStatus.OK, listVo, "Success");
		} catch (Exception ex) {
			return new GateWayResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
		//return new GateWayResponse<List<ListOfReturnSlipsVo>>(customerService.getListOfReturnSlips(vo));

	}

}
