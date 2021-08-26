package com.otsi.retail.newSale.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.retail.newSale.common.CommonRequestMappigs;
import com.otsi.retail.newSale.service.CustomerService;
import com.otsi.retail.newSale.service.NewSaleService;
import com.otsi.retail.newSale.vo.BarcodeVo;
import com.otsi.retail.newSale.vo.CustomerDetails;
import com.otsi.retail.newSale.vo.DeliverySlipVo;
import com.otsi.retail.newSale.vo.ListOfDeliverySlipVo;
import com.otsi.retail.newSale.vo.ListOfSaleBillsVo;
import com.otsi.retail.newSale.vo.NewSaleVo;

/**
 * Controller class for accepting all the requests which are related to
 * CustomerSaving API, NewSale API, Create delivery slip API
 * 
 * @author Manikanta Guptha
 *
 */

@RestController
@CrossOrigin
@RequestMapping(CommonRequestMappigs.NEW_SALE)
public class NewSaleController {

	@Autowired
	private NewSaleService newSaleService;

	@Autowired
	private CustomerService service;

	// Save customer details API
	@PostMapping(path = CommonRequestMappigs.SAVE_CUSTOMERDETAILS, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCustomerDetails(@Valid @RequestBody CustomerDetails details) {
		try {
			ResponseEntity<?> result = service.saveCustomerDetails(details);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Get customer details from Mobile number
	@GetMapping(path = CommonRequestMappigs.GET_CUSTOMERDETAILS_BY_MOBILENUMBER)
	public ResponseEntity<?> getCustomerByMobileNumber(@RequestParam String mobileNumber) {

		ResponseEntity<?> customer = service.getCustomerByMobileNumber(mobileNumber);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	// Method for saving new sale items...
	@PostMapping(CommonRequestMappigs.SALE)
	public ResponseEntity<?> saveNewSale(@RequestBody NewSaleVo vo) {

		ResponseEntity<?> message = newSaleService.saveNewSaleRequest(vo);

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// Method for create new Barcode..
	@PostMapping(CommonRequestMappigs.CREATE_BARCODE)
	public ResponseEntity<?> saveBarcode(@RequestBody BarcodeVo vo) {

		ResponseEntity<?> result = newSaleService.saveBarcode(vo);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// Method for getting Barcode details from Barcode table using Barcode number
	@GetMapping(CommonRequestMappigs.GET_BARCODE_DETAILS)
	public ResponseEntity<?> getBarcodeDetails(@RequestParam String barCode) {

		ResponseEntity<?> barCodeDetails = newSaleService.getBarcodeDetails(barCode);

		return new ResponseEntity<>(barCodeDetails, HttpStatus.OK);

	}

	// Method for creating Delivery slip using List of Barcodes
	@PostMapping(CommonRequestMappigs.CREATE_DS)
	public ResponseEntity<?> saveDeliverySlip(@RequestBody DeliverySlipVo vo) {

		try {
			ResponseEntity<?> saveDs = newSaleService.saveDeliverySlip(vo);
			return new ResponseEntity<>(saveDs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Method for getting Delivery slip Data using DsNumber
	@GetMapping(CommonRequestMappigs.GET_DS)
	public ResponseEntity<?> getDeliverySlipDetails(@RequestParam String dsNumber) {

		try {
			ResponseEntity<?> dsDetails = newSaleService.getDeliverySlipDetails(dsNumber);
			return new ResponseEntity<>(dsDetails, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	// Method for getting list of sale bills
	@GetMapping(CommonRequestMappigs.GET_LISTOF_SALEBILLS)
	public ResponseEntity<?> getListOfSaleBills(@RequestBody ListOfSaleBillsVo svo) {
		try {

			ResponseEntity<?> listOfSaleBills = newSaleService.getListOfSaleBills(svo);
			return new ResponseEntity<>(listOfSaleBills, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	// Method for getting list of delivery slips

	@GetMapping(CommonRequestMappigs.GET_LISTOF_DS)
	public ResponseEntity<?> getlistofDeliverySlips(@RequestBody ListOfDeliverySlipVo listOfDeliverySlipVo) {

		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {

			ResponseEntity<?> getDs = newSaleService.getlistofDeliverySlips(listOfDeliverySlipVo);

			return new ResponseEntity<>(getDs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}
	// Method for day closer

	@GetMapping(value = "daycloser")
	public ResponseEntity<?> dayclose() {
		try {
			ResponseEntity<?> dayclose = newSaleService.posDayClose();
			return new ResponseEntity<>(dayclose, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}
}
