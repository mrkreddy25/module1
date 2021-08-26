/**
 * mapper for NewSale
 */
package com.otsi.retail.debitnotes.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.otsi.retail.debitnotes.model.NewSaleEntity;
import com.otsi.retail.debitnotes.vo.NewSaleVo;

/**
 * @author vasavi
 *
 */
@Component
public class NewSaleMapper {

	/*
	 * EntityToVo converts dto to vo
	 * 
	 */
	@Autowired
	private DebitNotesMapper debitNotesMapper;

	public NewSaleVo EntityToVo(NewSaleEntity dto) {
		NewSaleVo vo = new NewSaleVo();
		vo.setInvoiceNumber(dto.getInvoiceNumber());
		vo.setDebitNotes(debitNotesMapper.EntityToVo(dto.getDebitNotes()));

		return vo;
	}

	public List<NewSaleVo> EntityToVo(List<NewSaleEntity> dtos) {
		return dtos.stream().map(dto -> EntityToVo(dto)).collect(Collectors.toList());

	}

	/*
	 * mapVoToEntity converts vo to dto
	 * 
	 */

	public NewSaleEntity mapVoToEntity(NewSaleVo vo) {
		NewSaleEntity dto = new NewSaleEntity();
		dto.setInvoiceNumber(vo.getInvoiceNumber());
		dto.setDebitNotes(debitNotesMapper.mapVoToEntity(vo.getDebitNotes()));
		return dto;

	}

	public List<NewSaleEntity> mapVoToEntity(List<NewSaleVo> vos) {
		return vos.stream().map(vo -> mapVoToEntity(vo)).collect(Collectors.toList());

	}

}
