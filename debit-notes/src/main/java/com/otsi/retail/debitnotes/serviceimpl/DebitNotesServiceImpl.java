package com.otsi.retail.debitnotes.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.otsi.retail.debitnotes.mapper.DebitNotesMapper;
import com.otsi.retail.debitnotes.model.DebitNotes;
import com.otsi.retail.debitnotes.repo.DebitNotesRepo;
import com.otsi.retail.debitnotes.service.DebitNotesService;
import com.otsi.retail.debitnotes.vo.CustomerVo;
import com.otsi.retail.debitnotes.vo.DebitNotesVo;
import com.otsi.retail.debitnotes.vo.NewSaleResponseVo;

@Component
public class DebitNotesServiceImpl implements DebitNotesService {

	private Logger log = LoggerFactory.getLogger(DebitNotesServiceImpl.class);

	@Value("${getcustomerdetailsbymobilenumber.url}")
	private String customerByMobileNoUrl;

	@Value("${getNewsaleByCustomerId.url}")
	private String newsaleByCustomerId;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DebitNotesRepo debitNotesRepo;

	@Autowired
	private DebitNotesMapper debitNotesMapper;

	@Override
	public DebitNotesVo saveDebitNotes(@Valid DebitNotesVo debitNotesVo) {
		log.debug("debugging saveDebitNotes:" + debitNotesVo);
		DebitNotes debitNotes = debitNotesMapper.mapVoToEntity(debitNotesVo);
		NewSaleResponseVo resVo = new NewSaleResponseVo();
		resVo.setCustomerId(debitNotesVo.getCustomerId());
		resVo.setNewsaleId(debitNotesVo.getNewsaleId());
		resVo.setPaymentAmountTypeId(debitNotesVo.getPaymentAmountTypeId());
		resVo.setInvoiceNumber(debitNotesVo.getInvoiceNumber());
		ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8082/newsale/updateNewsale", resVo,
				String.class);
		if (!result.hasBody()) {

			log.error("invoice number doesn't exists");
			throw new RuntimeException("invoice number doesn't exists");

		}

		DebitNotesVo debitNotesSave = debitNotesMapper.EntityToVo(debitNotesRepo.save(debitNotes));
		log.warn("we are testing is saving debit notes ");
		log.info("after saving debitnotes :" + debitNotesSave.toString());
		return debitNotesSave;

	}

	@Override
	public Optional<DebitNotes> getDebitNotesByDrNo(String drNo) {
		log.debug("debugging getDebitNotesByDrNo:" + drNo);
		Optional<DebitNotes> vo = debitNotesRepo.findByDrNo(drNo);
		log.warn("we are testing is fetching getDebitNotesByDrNo ");
		log.info("after fetching getDebitNotesByDrNo :" + vo.toString());
		return vo;
	}

	@Override
	public List<DebitNotes> getAllDebitNotes() {
		log.debug("debugging getAllDebitNotes:");
		List<DebitNotes> vo = debitNotesRepo.findAll();
		log.warn("we are testing is fetching all debit notes");
		log.info("after fetching all debitnotes:" + vo.toString());
		return vo;
	}

	@Override
	public List<DebitNotesVo> saveListDebitNotes(List<DebitNotesVo> debitNotesVos) {
		log.debug("debugging saveListDebitNotes:" + debitNotesVos);
		List<DebitNotes> voList = debitNotesMapper.mapVoToEntity(debitNotesVos);
		debitNotesVos = debitNotesMapper.EntityToVo(debitNotesRepo.saveAll(voList));
		log.warn("we are testing is saving all debit notes");
		log.info("after saving all debitnotes:" + debitNotesVos.toString());
		return debitNotesVos;
	}

	@Override
	public CustomerVo getDebitWithCustomerMobileno(String mobileNumber) {
		log.debug("debugging getDebitWithCustomerMobileno:" + mobileNumber);
		ResponseEntity<?> customerResponse = restTemplate
				.exchange(customerByMobileNoUrl + "?mobileNumber=" + mobileNumber, HttpMethod.GET, null, String.class);
		ObjectMapper mapper = new ObjectMapper();
		// GateWayResponse<?> gatewayResponse =
		// mapper.convertValue(customerResponse.getBody(), GateWayResponse.class);
		CustomerVo vo = null;
		try {
			vo = mapper.readValue(customerResponse.getBody().toString(), CustomerVo.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		log.warn("we are testing is getDebitWithCustomerMobileno");
		log.info("after fetching getDebitWithCustomerMobileno:" + vo.toString());
		return vo;
	}

	@Override
	public List<NewSaleResponseVo> getNewsaleByCustomerId(Long customerId) {
		log.debug("debugging getNewsaleByCustomerId:" + customerId);
		ResponseEntity<?> newsaleResponse = restTemplate.exchange(newsaleByCustomerId + "?customerId=" + customerId,
				HttpMethod.GET, null, String.class);
		ObjectMapper mapper = new ObjectMapper();
		// GateWayResponse<?> gatewayResponse =
		// mapper.convertValue(newsaleResponse.getBody(), GateWayResponse.class);
		List<NewSaleResponseVo> vo = null;
		try {
			vo = mapper.readValue(newsaleResponse.getBody().toString(), new TypeReference<List<NewSaleResponseVo>>() {
			});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.warn("we are testing is getNewsaleByCustomerId");
		log.info("after fetching getNewsaleByCustomerId:" + vo.toString());
		return vo;
	}

}
