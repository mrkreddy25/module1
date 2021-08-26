package com.otsi.retail.debitnotes.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.otsi.retail.debitnotes.model.DebitNotes;
import com.otsi.retail.debitnotes.vo.CustomerVo;
import com.otsi.retail.debitnotes.vo.DebitNotesVo;
import com.otsi.retail.debitnotes.vo.NewSaleResponseVo;
import com.otsi.retail.debitnotes.vo.NewSaleVo;

@Service
public interface DebitNotesService {

	DebitNotesVo saveDebitNotes(@Valid DebitNotesVo debitNotesVo);

	Optional<DebitNotes> getDebitNotesByDrNo(String drNo);

	List<DebitNotes>  getAllDebitNotes();

	List<DebitNotesVo> saveListDebitNotes(List<DebitNotesVo> debitNotesVos);

	CustomerVo getDebitWithCustomerMobileno(String CustomerName);

	List<NewSaleResponseVo> getNewsaleByCustomerId(Long customerId);

	

	

}
