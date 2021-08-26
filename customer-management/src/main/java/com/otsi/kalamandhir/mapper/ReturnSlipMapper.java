package com.otsi.kalamandhir.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


import com.otsi.kalamandhir.model.Barcode;

import com.otsi.kalamandhir.model.listOfReturnSlipsModel;
import com.otsi.kalamandhir.vo.BarcodeVo;
import com.otsi.kalamandhir.vo.ListOfReturnSlipsVo;

/**
 * @author lakshmi
 *
 */

@Component
public class ReturnSlipMapper {

	
	
	public List<ListOfReturnSlipsVo> mapEntityToVo(List<listOfReturnSlipsModel> dtos) {
		return dtos.stream().map(dto -> mapEntityToVo(dto)).collect(Collectors.toList());

	}

	private ListOfReturnSlipsVo mapEntityToVo(listOfReturnSlipsModel dto) {
		
		ListOfReturnSlipsVo vo=new ListOfReturnSlipsVo();
		
		BeanUtils.copyProperties(dto, vo);
		/*
		 * vo.setRtNumber(dto.getRtNumber()); vo.setCreditNote(dto.getCreditNote());
		 * //vo.setAmount(dto.getBarcode().get(0).getAmount()); z
		 * vo.setCreatedInfo(dto.getCreatedInfo());
		 * vo.setSettelmentInfo(dto.getSettelmentInfo());
		 * //vo.setBarcodeVo(dto.getBarcode());
		 */		
		List<Barcode> barEnt = dto.getBarcode();
		

		List<BarcodeVo> listBarVo = new ArrayList<>();

		barEnt.stream().forEach(x -> {
			BarcodeVo barvo = new BarcodeVo();
			
			//barvo.setBarcode(x.getBarcode());
			//barvo.setAmount(x.getAmount());
			BeanUtils.copyProperties(x, barvo);

			/*
			 * barvo.setSalesMan(x.getSalesMan()); barvo.setQty(x.getQty());
			 * barvo.setPromoDisc(x.getPromoDisc()); barvo.setNetAmount(x.getNetAmount());
			 * barvo.setMrp(x.getMrp()); barvo.setItemDesc(x.getItemDesc());
			 */

			listBarVo.add(barvo);
		});
		vo.setBarcodeVo(listBarVo);

		return vo;
	}

}
