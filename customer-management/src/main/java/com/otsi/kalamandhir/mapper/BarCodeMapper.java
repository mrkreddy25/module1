/**
 * mapper for Barcode
 */
package com.otsi.kalamandhir.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.otsi.kalamandhir.model.Barcode;
import com.otsi.kalamandhir.vo.BarcodeVo;

/**
 * @author vasavi
 *
 */
@Component
public class BarCodeMapper {

	/*
	 * EntityToVo converts dto to vo
	 * 
	 */

	public BarcodeVo EntityToVo(Barcode dto) {
		BarcodeVo vo = new BarcodeVo();
		vo.setId(dto.getId());
		vo.setBarcodeId(dto.getBarcodeId());
		vo.setAmount(dto.getAmount());
		vo.setInvoice(dto.getInvoice());
		vo.setQuantity(dto.getQuantity());
		vo.setRtnQuantity(dto.getRtnQuantity());
		vo.setReason(dto.getReason());
		return vo;
	}

	/*
	 * list of EntityToVo to convert dto's to vo's
	 */

	public List<BarcodeVo> EntityToVo(List<Barcode> dtos) {
		return dtos.stream().map(dto -> EntityToVo(dto)).collect(Collectors.toList());

	}

	/*
	 * mapVoToEntity converts vo to dto
	 * 
	 */

	public Barcode mapVoToEntity(BarcodeVo vo) {
		Barcode dto = new Barcode();
		dto.setId(vo.getId());
		dto.setBarcodeId(vo.getBarcodeId());
		dto.setAmount(vo.getAmount());
		dto.setInvoice(vo.getInvoice());
		dto.setQuantity(vo.getQuantity());
		dto.setRtnQuantity(vo.getRtnQuantity());
		dto.setReason(vo.getReason());
		return dto;

	}

	/*
	 * list of mapVoToEntity to convert vo's to dto's
	 */

	public List<Barcode> mapVoToEntity(List<BarcodeVo> vos) {
		return vos.stream().map(vo -> mapVoToEntity(vo)).collect(Collectors.toList());

	}
}
