package com.newsaleapi.mapper;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.newsaleapi.Entity.BarcodeEntity;
import com.newsaleapi.vo.BarcodeVo;

@Component
public class NewSaleMapper {

	public BarcodeEntity convertBarcodeVoToEntity(BarcodeVo vo) {

		BarcodeEntity entity = new BarcodeEntity();

		entity.setBarcode(vo.getBarcode());
		entity.setItemDesc(vo.getItemDesc());
		entity.setMrp(vo.getMrp());
		entity.setNetAmount(vo.getNetAmount());
		entity.setPromoDisc(vo.getPromoDisc());
		entity.setQty(vo.getQty());
		entity.setSalesMan(vo.getSalesMan());
		entity.setCreatedDate(LocalDateTime.now());

		return entity;
	}

	public BarcodeVo convertBarcodeEntityToVo(BarcodeEntity entity) {

		BarcodeVo vo = new BarcodeVo();

		vo.setBarcode(entity.getBarcode());
		vo.setItemDesc(entity.getItemDesc());
		vo.setMrp(entity.getMrp());
		vo.setNetAmount(entity.getNetAmount());
		vo.setPromoDisc(entity.getPromoDisc());
		vo.setQty(entity.getQty());
		vo.setSalesMan(entity.getSalesMan());

		return vo;
	}

}
