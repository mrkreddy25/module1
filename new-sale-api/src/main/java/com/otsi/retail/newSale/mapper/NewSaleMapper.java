package com.otsi.retail.newSale.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.otsi.retail.newSale.Entity.BarcodeEntity;
import com.otsi.retail.newSale.Entity.DeliverySlipEntity;
import com.otsi.retail.newSale.Entity.NewSaleEntity;
import com.otsi.retail.newSale.vo.BarcodeVo;
import com.otsi.retail.newSale.vo.DeliverySlipVo;
import com.otsi.retail.newSale.vo.ListOfDeliverySlipVo;
import com.otsi.retail.newSale.vo.ListOfSaleBillsVo;
import com.otsi.retail.newSale.vo.NewSaleVo;

@Component
public class NewSaleMapper {

	public BarcodeEntity convertBarcodeVoToEntity(BarcodeVo vo) {

		BarcodeEntity entity = new BarcodeEntity();

		BeanUtils.copyProperties(vo, entity);

		/*
		 * entity.setBarcode(vo.getBarcode()); entity.setItemDesc(vo.getItemDesc());
		 * entity.setMrp(vo.getMrp()); entity.setNetAmount(vo.getNetAmount());
		 * entity.setPromoDisc(vo.getPromoDisc()); entity.setQty(vo.getQty());
		 * entity.setSalesMan(vo.getSalesMan());
		 */
		entity.setCreatedDate(LocalDateTime.now());

		return entity;
	}

	public BarcodeVo convertBarcodeEntityToVo(BarcodeEntity entity) {

		BarcodeVo vo = new BarcodeVo();

		BeanUtils.copyProperties(entity, vo);

		/*
		 * vo.setBarcode(entity.getBarcode()); vo.setItemDesc(entity.getItemDesc());
		 * vo.setMrp(entity.getMrp()); vo.setNetAmount(entity.getNetAmount());
		 * vo.setPromoDisc(entity.getPromoDisc()); vo.setQty(entity.getQty());
		 * vo.setSalesMan(entity.getSalesMan());
		 */

		return vo;
	}

	public DeliverySlipEntity convertDSVoToEntity(DeliverySlipVo vo) {

		return null;
	}

	public ListOfSaleBillsVo convertlistSalesEntityToVo(List<NewSaleEntity> saleDetails) {

		ListOfSaleBillsVo lsvo = new ListOfSaleBillsVo();
		List<NewSaleVo> sVoList = new ArrayList<>();

		saleDetails.stream().forEach(x -> {

			NewSaleVo nsvo = new NewSaleVo();

			//BeanUtils.copyProperties(x, nsvo);
			
			  nsvo.setInvoiceNumber(x.getInvoiceNumber()); 
			  nsvo.setBiller(x.getBiller());
			  nsvo.setCreatedDate(x.getCreatedDate());
			  nsvo.setTotalManualDisc(x.getTotalManualDisc());
			  nsvo.setApprovedBy(x.getApprovedBy());
			  nsvo.setReason(x.getReason());
			  nsvo.setOfflineNumber(x.getOfflineNumber());
			 

			sVoList.add(nsvo);

		});
		lsvo.setAmount(saleDetails.stream().mapToLong(i -> i.getNetPayableAmount()).sum());

		lsvo.setNewSaleVo(sVoList);
		return lsvo;
	}

	public ListOfDeliverySlipVo convertListDSToVo(List<DeliverySlipEntity> dsDetails) {

		ListOfDeliverySlipVo vo = new ListOfDeliverySlipVo();

		List<DeliverySlipVo> dsVoList = new ArrayList<>();

		dsDetails.stream().forEach(x -> {

			DeliverySlipVo dsvo = new DeliverySlipVo();

			BeanUtils.copyProperties(x, dsvo);
			

			dsVoList.add(dsvo);

		});

		vo.setToatalPromoDisc(dsDetails.stream().mapToLong(i -> i.getPromoDisc()).sum());
		vo.setTotalNetAmount(dsDetails.stream().mapToLong(i -> i.getNetAmount()).sum());
		vo.setTotalGrossAmount(dsDetails.stream().mapToLong(i -> i.getMrp()).sum());
		vo.setDeliverySlipVo(dsVoList);

		return vo;
	}

}
