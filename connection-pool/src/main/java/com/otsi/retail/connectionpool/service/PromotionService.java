package com.otsi.retail.connectionpool.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.otsi.retail.connectionpool.vo.PromotionsVo;

@Component
public interface PromotionService {

	Map<String, Object> addPromotion(PromotionsVo vo);

	ResponseEntity<?> getListOfPromotions(String flag);

	String editPromotion(PromotionsVo vo);

}
