/**
 * mapper for TagCustomer
 */
package com.otsi.kalamandhir.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.otsi.kalamandhir.model.TagCustomer;
import com.otsi.kalamandhir.vo.TagCustomerVo;

/**
 * @author vasavi
 *
 */
@Component
public class TagCustomerMapper {

	@Autowired
	private BarCodeMapper barcodeMapper;

	@Autowired
	private StoreMapper storeMapper;

	/*
	 * EntityToVo converts dto to vo
	 * 
	 */

	public TagCustomerVo EntityToVo(TagCustomer dto) {
		TagCustomerVo vo = new TagCustomerVo();
		vo.setId(dto.getId());
		vo.setMobileNumber(dto.getMobileNumber());
		vo.setFromDate(dto.getFromDate());
		vo.setToDate(dto.getToDate());
		vo.setBillNo(dto.getBillNo());
		vo.setBarcodeVo(barcodeMapper.EntityToVo(dto.getBarcode()));
		vo.setStoreVo(storeMapper.EntityToVo(dto.getStores()));
		return vo;
	}

	/*
	 * to convert list dto's to vo's
	 */

	public List<TagCustomerVo> EntityToVo(List<TagCustomer> dtos) {
		return dtos.stream().map(dto -> EntityToVo(dto)).collect(Collectors.toList());

	}

	/*
	 * mapVoToEntity converts vo to dto
	 * 
	 */

	public TagCustomer mapVoToEntity(TagCustomerVo vo) {

		TagCustomer dto = new TagCustomer();
		dto.setId(vo.getId());
		dto.setMobileNumber(vo.getMobileNumber());
		dto.setBarcode(barcodeMapper.mapVoToEntity(vo.getBarcodeVo()));
		dto.setFromDate(vo.getFromDate());
		dto.setToDate(vo.getToDate());
		dto.setBillNo(vo.getBillNo());
		dto.setStores(storeMapper.mapVoToEntity(vo.getStoreVo()));
		return dto;

	}

	/*
	 * to convert list vo's to dto's
	 * 
	 */
	public List<TagCustomer> mapVoToEntity(List<TagCustomerVo> vos) {
		return vos.stream().map(vo -> mapVoToEntity(vo)).collect(Collectors.toList());

	}

}
