package com.otsi.retail.newSale.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.otsi.retail.newSale.Entity.BarcodeEntity;
import com.otsi.retail.newSale.Entity.CustomerDetailsEntity;
import com.otsi.retail.newSale.Entity.DeliverySlipEntity;
import com.otsi.retail.newSale.Entity.NewSaleEntity;
import com.otsi.retail.newSale.common.DSStatus;
import com.otsi.retail.newSale.mapper.DeliverySlipMapper;
import com.otsi.retail.newSale.mapper.NewSaleMapper;
import com.otsi.retail.newSale.repository.BarcodeRepository;
import com.otsi.retail.newSale.repository.CustomerDetailsRepo;
import com.otsi.retail.newSale.repository.DeliverySlipRepository;
import com.otsi.retail.newSale.repository.NewSaleRepository;
import com.otsi.retail.newSale.service.CustomerService;
import com.otsi.retail.newSale.service.NewSaleService;
import com.otsi.retail.newSale.vo.BarcodeVo;
import com.otsi.retail.newSale.vo.DeliverySlipVo;
import com.otsi.retail.newSale.vo.ListOfDeliverySlipVo;
import com.otsi.retail.newSale.vo.ListOfSaleBillsVo;
import com.otsi.retail.newSale.vo.MessageVo;
import com.otsi.retail.newSale.vo.NewSaleVo;


/**
 * Service class contains all bussiness logics related to new sale , create
 * barcode , getting barcode details and create delivery slip
 * 
 * @author Manikanta Guptha
 *
 */
@Service
@Configuration
public class NewSaleServiceImpl implements NewSaleService {

	@Autowired
	private RestTemplate template;

	@Autowired
	private NewSaleMapper newSaleMapper;

	@Autowired
	private BarcodeRepository barcodeRepository;

	@Autowired
	private DeliverySlipRepository dsRepo;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerDetailsRepo customerRepo;

	@Autowired
	private NewSaleRepository newSaleRepository;

	@Autowired
	private DeliverySlipMapper dsMapper;

	@Value("${savecustomer.url}")
	private String url;

	@Override
	public ResponseEntity<?> saveNewSaleRequest(NewSaleVo vo) {

		Random ran = new Random();

		NewSaleEntity entity = new NewSaleEntity();

		if (vo.getCustomerDetails() != null) {

			try {
				customerService.saveCustomerDetails(vo.getCustomerDetails());
			} catch (Exception e) {

				e.printStackTrace();
			}

			List<DeliverySlipVo> dlSlips = vo.getDlSlip();

			entity.setNatureOfSale(vo.getNatureOfSale());
			entity.setPayType(vo.getPayType());
			entity.setGrossAmount(dlSlips.stream().mapToLong(i -> i.getMrp()).sum());
			entity.setTotalPromoDisc(dlSlips.stream().mapToLong(i -> i.getPromoDisc()).sum());
			entity.setTotalManualDisc(vo.getTotalManualDisc());
			entity.setCreatedDate(LocalDate.now());

			Long net = dlSlips.stream().mapToLong(i -> i.getNetAmount()).sum() - vo.getTotalManualDisc();

			entity.setNetPayableAmount(net);

			entity.setBillNumber(
					"KLM/" + LocalDate.now().getYear() + LocalDate.now().getDayOfMonth() + "/" + ran.nextInt());

			List<String> dlsList = dlSlips.stream().map(x -> x.getDsNumber()).collect(Collectors.toList());

			List<DeliverySlipEntity> dsList = dsRepo.findByDsNumberIn(dlsList);

			if (dsList.size() == vo.getDlSlip().size()) {

				NewSaleEntity saveEntity = newSaleRepository.save(entity);

				dsList.stream().forEach(a -> {

					a.setNewsale(saveEntity);
					a.setLastModified(LocalDateTime.now());

					dsRepo.save(a);
				});

			} else {
				return new ResponseEntity<>("Please enter Valid delivery slips..", HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<>("Bill generated with number :" + entity.getBillNumber(), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> saveBarcode(BarcodeVo vo) {

		BarcodeEntity barcodeDetails = barcodeRepository.findByBarcode(vo.getBarcode());
		if (barcodeDetails == null) {

			BarcodeEntity barcode = newSaleMapper.convertBarcodeVoToEntity(vo);
			barcodeRepository.save(barcode);

			return new ResponseEntity<>("Barcode details saved successfully..", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Barcode with " + vo.getBarcode() + " is already exists",
					HttpStatus.BAD_GATEWAY);
		}
	}

	@Override
	public ResponseEntity<?> getBarcodeDetails(String barCode) {

		BarcodeEntity barcodeDetails = barcodeRepository.findByBarcode(barCode);

		if (barcodeDetails == null) {
			return new ResponseEntity<>("Barcode with number " + barCode + " is not exists", HttpStatus.BAD_GATEWAY);
		} else {
			BarcodeVo vo = newSaleMapper.convertBarcodeEntityToVo(barcodeDetails);
			return new ResponseEntity<>(vo, HttpStatus.OK);
		}
	}

	// Method for saving delivery slip
	@Override
	public ResponseEntity<?> saveDeliverySlip(DeliverySlipVo vo) {
		try {

			Random ran = new Random();
			DeliverySlipEntity entity = dsMapper.convertDsVoToEntity(vo);

			entity.setDsNumber(
					"DS/" + LocalDate.now().getYear() + LocalDate.now().getDayOfMonth() + "/" + ran.nextInt());

			DeliverySlipEntity savedEntity = dsRepo.save(entity);

			List<BarcodeVo> barVo = vo.getBarcode();
			List<String> barcodeList = barVo.stream().map(x -> x.getBarcode()).collect(Collectors.toList());

			List<BarcodeEntity> barcodeDetails = barcodeRepository.findByBarcodeIn(barcodeList);

			barcodeDetails.stream().forEach(a -> {

				a.setDeliverySlip(savedEntity);
				a.setLastModified(LocalDateTime.now());

				barcodeRepository.save(a);
			});
			MessageVo message = new MessageVo();
			message.setMessage("Successfully created deliverySlip with DS Number " + entity.getDsNumber());
			message.setNumber(entity.getDsNumber());

			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("error occurs while saving Delivery slip", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> getDeliverySlipDetails(String dsNumber) {
		try {
			DeliverySlipEntity dsEntity = dsRepo.findByDsNumber(dsNumber);

			if (dsEntity != null) {
				if (!dsEntity.getBarcodes().isEmpty()) {
					DeliverySlipVo vo = dsMapper.convertDsEntityToVo(dsEntity);

					return new ResponseEntity<>(vo, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Barcode details not exists with given DS Number",
							HttpStatus.BAD_REQUEST);
				}

			} else {
				return new ResponseEntity<>("No record with DsNumber :" + dsNumber, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("error occurs while saving Delivery slip", HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public ResponseEntity<?> getListOfSaleBills(ListOfSaleBillsVo svo) {

		List<NewSaleEntity> saleDetails = new ArrayList<>();

		/*
		 * getting the data using between dates and bill status or custMobileNumber or
		 * barCode or billNumber or invoiceNumber or dsNumber
		 */
		if (svo.getDateFrom() != null && svo.getDateTo() != null) {
			if (svo.getBillStatus() != null && svo.getCustMobileNumber() == null && svo.getBillNumber() == null
					&& svo.getBarcode() == null && svo.getInvoiceNumber() == null && svo.getDsNumber() == null) {

				saleDetails = newSaleRepository.findByCreatedDateBetweenAndBillStatus(svo.getDateFrom(),
						svo.getDateTo(), svo.getBillStatus());
			}
			/*
			 * getting the record using custmobilenumber
			 */
			else if (svo.getBillStatus() == null && svo.getCustMobileNumber() != null && svo.getBillNumber() == null
					&& svo.getBarcode() == null && svo.getInvoiceNumber() == null && svo.getDsNumber() == null) {

				Optional<CustomerDetailsEntity> customer = customerRepo.findByMobileNumber(svo.getCustMobileNumber());
				if (customer.isPresent()) {
					saleDetails = newSaleRepository.findByNewsaleId(customer.get().getNewsale().get(0).getNewsaleId());

				} else {
					return new ResponseEntity<>("No record found with given mobilenumber", HttpStatus.BAD_REQUEST);
				}

			}
			/*
			 * getting the record using barcode
			 */
			else if (svo.getBillStatus() == null && svo.getCustMobileNumber() == null && svo.getBillNumber() == null
					&& svo.getBarcode() != null && svo.getInvoiceNumber() == null && svo.getDsNumber() == null) {

				BarcodeEntity bar = barcodeRepository.findByBarcode(svo.getBarcode());
				if (bar != null) {

					saleDetails = newSaleRepository.findByNewsaleId(bar.getDeliverySlip().getNewsale().getNewsaleId());

				} else {
					return new ResponseEntity<>("No record found with given barcode", HttpStatus.BAD_REQUEST);
				}

			}
			/*
			 * getting the record using billNumber
			 */
			else if (svo.getBillStatus() == null && svo.getCustMobileNumber() == null && svo.getBillNumber() != null
					&& svo.getBarcode() == null && svo.getInvoiceNumber() == null && svo.getDsNumber() == null) {
				saleDetails = newSaleRepository.findByBillNumber(svo.getBillNumber());
			}
			/*
			 * getting the record using invoice number
			 */
			else if (svo.getBillStatus() == null && svo.getCustMobileNumber() == null && svo.getBillNumber() == null
					&& svo.getBarcode() == null && svo.getInvoiceNumber() != null && svo.getDsNumber() == null) {
				saleDetails = newSaleRepository.findByInvoiceNumber(svo.getInvoiceNumber());
			}
			/*
			 * getting the record using dsNumber
			 */
			else if (svo.getBillStatus() == null && svo.getCustMobileNumber() == null && svo.getBillNumber() == null
					&& svo.getBarcode() == null && svo.getInvoiceNumber() == null && svo.getDsNumber() != null) {
				DeliverySlipEntity ds = dsRepo.findByDsNumber(svo.getDsNumber());

				if (ds != null) {
					saleDetails = newSaleRepository.findByNewsaleId(ds.getNewsale().getNewsaleId());
				}
			} else
				saleDetails = newSaleRepository.findByCreatedDateBetween(svo.getDateFrom(), svo.getDateTo());

			if (saleDetails != null) {

				ListOfSaleBillsVo lsvo = newSaleMapper.convertlistSalesEntityToVo(saleDetails);
				return new ResponseEntity<>(lsvo, HttpStatus.OK);

			}

			else {

				return new ResponseEntity<>("No record found with given information", HttpStatus.BAD_REQUEST);
			}

		}
		return new ResponseEntity<>("sucessfully getting the records", HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> getlistofDeliverySlips(ListOfDeliverySlipVo listOfDeliverySlipVo) {

		List<DeliverySlipEntity> dsDetails = new ArrayList<DeliverySlipEntity>();
		/*
		 * getting the record using barcode
		 */

		if (listOfDeliverySlipVo.getDateFrom() == null && listOfDeliverySlipVo.getDateTo() == null
				&& listOfDeliverySlipVo.getDsNumber() == null && listOfDeliverySlipVo.getStatus() == null
				&& listOfDeliverySlipVo.getBarcode() != null) {

			BarcodeEntity bar = barcodeRepository.findByBarcode(listOfDeliverySlipVo.getBarcode());

			if (bar != null) {
				dsDetails = dsRepo.findByDsId(bar.getDeliverySlip().getDsId());

			} else {
				return new ResponseEntity<>("No record found with given barcode", HttpStatus.BAD_REQUEST);
			}
		}
		/*
		 * getting the record using barcode and dates
		 */

		if (listOfDeliverySlipVo.getDateFrom() != null && listOfDeliverySlipVo.getDateTo() != null
				&& listOfDeliverySlipVo.getDsNumber() == null && listOfDeliverySlipVo.getStatus() == null
				&& listOfDeliverySlipVo.getBarcode() != null) {

			BarcodeEntity bar = barcodeRepository.findByBarcode(listOfDeliverySlipVo.getBarcode());

			if (bar != null) {
				dsDetails = dsRepo.findByCreatedDateBetweenAndDsId(listOfDeliverySlipVo.getDateFrom(),
						listOfDeliverySlipVo.getDateTo(), bar.getDeliverySlip().getDsId());

			} else {
				return new ResponseEntity<>("No record found with given barcode", HttpStatus.BAD_REQUEST);
			}
		}
		/*
		 * getting the record using dsNumber and dates
		 */
		if (listOfDeliverySlipVo.getDateFrom() != null && listOfDeliverySlipVo.getDateTo() != null
				&& listOfDeliverySlipVo.getDsNumber() != null && listOfDeliverySlipVo.getStatus() == null
				&& listOfDeliverySlipVo.getBarcode() == null) {

			dsDetails = dsRepo.findByCreatedDateBetweenAndDsNumber(listOfDeliverySlipVo.getDateFrom(),
					listOfDeliverySlipVo.getDateTo(), listOfDeliverySlipVo.getDsNumber());

			if (dsDetails == null) {

				return new ResponseEntity<>("No record found with given information", HttpStatus.BAD_REQUEST);
			}

		}
		/*
		 * getting the record using status and dates
		 */
		if (listOfDeliverySlipVo.getDateFrom() != null && listOfDeliverySlipVo.getDateTo() != null
				&& listOfDeliverySlipVo.getDsNumber() == null && listOfDeliverySlipVo.getStatus() != null
				&& listOfDeliverySlipVo.getBarcode() == null) {

			dsDetails = dsRepo.findByCreatedDateBetweenAndStatus(listOfDeliverySlipVo.getDateFrom(),
					listOfDeliverySlipVo.getDateTo(), listOfDeliverySlipVo.getStatus());

			if (dsDetails == null) {

				return new ResponseEntity<>("No record found with given information", HttpStatus.BAD_REQUEST);
			}

		}

		/*
		 * getting the record using dsNumber
		 */

		if (listOfDeliverySlipVo.getDateFrom() == null && listOfDeliverySlipVo.getDateTo() == null
				&& listOfDeliverySlipVo.getDsNumber() != null && listOfDeliverySlipVo.getStatus() == null
				&& listOfDeliverySlipVo.getBarcode() == null) {

			// List<String> dlsList = listOfDeliverySlipVo.stream().map(x ->
			// x.getDsNumber()).collect(Collectors.toList());
			List<String> dsList = new ArrayList<>();
			dsList.add(listOfDeliverySlipVo.getDsNumber());
			dsDetails = dsRepo.findByDsNumberIn(dsList);

			if (dsDetails.isEmpty()) {

				/*
				 * throw new RuntimeException( "No record found with giver DS Number :" +
				 * listOfDeliverySlipVo.getDsNumber());
				 */
				return new ResponseEntity<>("No record found with giver DS Number", HttpStatus.BAD_REQUEST);
			}

		}

		/*
		 * getting the record using status
		 */

		if (listOfDeliverySlipVo.getDateFrom() == null && listOfDeliverySlipVo.getDateTo() == null
				&& listOfDeliverySlipVo.getDsNumber() == null && listOfDeliverySlipVo.getStatus() != null
				&& listOfDeliverySlipVo.getBarcode() == null) {

			dsDetails = dsRepo.findByStatus(listOfDeliverySlipVo.getStatus());

			if (dsDetails == null) {

				return new ResponseEntity<>("No record found with giver DS Number", HttpStatus.BAD_REQUEST);
			}

		}
		/*
		 * getting the record using dates
		 */
		if (listOfDeliverySlipVo.getDateFrom() != null && listOfDeliverySlipVo.getDateTo() != null
				&& listOfDeliverySlipVo.getDsNumber() == null && listOfDeliverySlipVo.getStatus() == null
				&& listOfDeliverySlipVo.getBarcode() == null) {

			dsDetails = dsRepo.findByCreatedDateBetween(listOfDeliverySlipVo.getDateFrom(),
					listOfDeliverySlipVo.getDateTo());

			if (dsDetails == null) {

				return new ResponseEntity<>("No record found with given information", HttpStatus.BAD_REQUEST);
			}

		}

		ListOfDeliverySlipVo mapper = newSaleMapper.convertListDSToVo(dsDetails);
		return new ResponseEntity<>(mapper, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> posDayClose() {
		
		List<DeliverySlipEntity> DsList = dsRepo.findByStatusAndCreatedDate(DSStatus.Pending,LocalDate.now());

		if (DsList.isEmpty()) {
			return new ResponseEntity<>("successfully we can close the day of pos " + " uncleared delivery Slips count :  "+ DsList.size(),HttpStatus.OK);

		} else
			return new ResponseEntity<>("to  close the day of pos please clear pending  delivery Slips"
					+ " uncleared delivery Slips count   " + DsList.size(),HttpStatus.BAD_REQUEST);
	}
}
