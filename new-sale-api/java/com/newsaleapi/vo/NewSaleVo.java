package com.newsaleapi.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.newsaleapi.common.PaymentType;
import com.newsaleapi.common.SaleNature;

import lombok.Data;

@Data
@Component
public class NewSaleVo {

	private CustomerDetails customerDetails;

	private List<DeliverySlipVo> dlSlip;

	private SaleNature natureOfSale;

	private PaymentType payType;

	private String custmerId;

	private Long grossAmount;

	private Long totalPromoDisc;

	private Long totalManualDisc;

	private float roundOff;

	private Long netPayableAmount;

}
