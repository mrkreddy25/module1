/**
 * mapper for DebitNotes
 */
package com.otsi.retail.debitnotes.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.otsi.retail.debitnotes.model.DebitNotes;
import com.otsi.retail.debitnotes.vo.DebitNotesVo;

/**
 * @author vasavi
 *
 */
@Component
public class DebitNotesMapper {

	/*
	 * @Autowired private CustomerMapper customerMapper;
	 * 
	 * @Autowired private BarcodeMapper barcodeMapper;
	 * 
	 * @Autowired private NewSaleMapper newSaleMapper;
	 */

	@Autowired
	private NewSaleMapper newSaleMapper;

	/*
	 * EntityToVo converts dto to vo
	 * 
	 */

	public DebitNotesVo EntityToVo(DebitNotes dto) {
		DebitNotesVo vo = new DebitNotesVo();
		Random ran = new Random();

		vo.setDrNo("DR/" + LocalDate.now().getYear() + LocalDate.now().getDayOfMonth() + "/" + ran.nextInt());
		// vo.setCustomerName(customerMapper.EntityToVo(dto.getCustomerName()));
		vo.setCustomerName(dto.getCustomerName());
		vo.setInvoiceNumber(dto.getInvoiceNumber());
		vo.setStoreName(dto.getStoreName());
		vo.setCreatedDate(LocalDate.now());
		vo.setAmount(dto.getAmount());
				/*
		 * vo.setStoreName(barcodeMapper.EntityToVo(dto.getStoreName()));
		 * vo.setInvoiceNo(newSaleMapper.EntityToVo(dto.getInvoiceNo()));
		 */
		return vo;
	}

	public List<DebitNotesVo> EntityToVo(List<DebitNotes> dtos) {
		return dtos.stream().map(dto -> EntityToVo(dto)).collect(Collectors.toList());

	}

	/*
	 * mapVoToEntity converts vo to dto
	 * 
	 */

	public DebitNotes mapVoToEntity(DebitNotesVo vo) {
		Random ran = new Random();
		DebitNotes dto = new DebitNotes();
		dto.setDrNo("DR/" + LocalDate.now().getYear() + LocalDate.now().getDayOfMonth() + "/" + ran.nextInt());
		// dto.setCustomerName(customerMapper.mapVoToEntity(vo.getCustomerName()));
		dto.setCustomerName(vo.getCustomerName());
		dto.setInvoiceNumber(vo.getInvoiceNumber());
		dto.setStoreName(vo.getStoreName());
		vo.setCreatedDate(LocalDate.now());
		dto.setCreatedDate(LocalDate.now());
		dto.setAmount(vo.getAmount());
		
		// dto.setInvoiceNo(newSaleMapper.mapVoToEntity(vo.getInvoiceNo()));
		// dto.setStoreName(barcodeMapper.mapVoToEntity(vo.getStoreName()));

		return dto;

	}

	public List<DebitNotes> mapVoToEntity(List<DebitNotesVo> vos) {
		return vos.stream().map(vo -> mapVoToEntity(vo)).collect(Collectors.toList());

	}

}
