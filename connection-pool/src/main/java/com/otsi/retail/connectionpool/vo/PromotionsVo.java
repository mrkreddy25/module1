package com.otsi.retail.connectionpool.vo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.otsi.retail.connectionpool.common.Applicability;
import com.otsi.retail.connectionpool.common.PromoApplyType;

import lombok.Data;

/**
 * This VO class contains all the inputs of Promotions
 * 
 * @author Manikanta Guptha
 *
 */

@Data
@Component
public class PromotionsVo {

	private Long promoId;

	private String promoName;

	private String description;

	private String printNameOnBill;

	private Applicability applicability;

	private PromoApplyType promoApplyType;

	private Boolean isTaxExtra;

	private int buyItemsFromPool;

	private Boolean isActive;

	private LocalDate createdDate;

	private LocalDate lastModified;

	private Boolean isForEdit;

	private List<ConnectionPoolVo> poolVo;

}
