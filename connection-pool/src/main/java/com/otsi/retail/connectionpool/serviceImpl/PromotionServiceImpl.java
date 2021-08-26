package com.otsi.retail.connectionpool.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.otsi.retail.connectionpool.entity.PoolEntity;
import com.otsi.retail.connectionpool.entity.PromotionsEntity;
import com.otsi.retail.connectionpool.mapper.PromotionMapper;
import com.otsi.retail.connectionpool.repository.PoolRepo;
import com.otsi.retail.connectionpool.repository.PromotionRepo;
import com.otsi.retail.connectionpool.service.PromotionService;
import com.otsi.retail.connectionpool.vo.ConnectionPoolVo;
import com.otsi.retail.connectionpool.vo.PromotionsVo;

/**
 * This class contains all Bussiness logics regarding promotions and their management
 * 
 * @author Manikanta Guptha
 *
 */

@Service
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	private PromotionMapper promoMapper;

	@Autowired
	private PromotionRepo promoRepo;

	@Autowired
	private PoolRepo poolRepo;

	// Method for adding promotion to pools
	@Override
	public Map<String, Object> addPromotion(PromotionsVo vo) {

		Map<String, Object> result = new HashMap<>();

		List<ConnectionPoolVo> poolVo = vo.getPoolVo();

		List<Long> poolIds = poolVo.stream().map(x -> x.getPoolId()).collect(Collectors.toList());

		List<PoolEntity> poolList = poolRepo.findByPoolIdInAndIsActive(poolIds, Boolean.TRUE);

		PromotionsEntity entity = promoMapper.convertPromoVoToEntity(vo, poolList);

		if (poolVo.size() == poolList.size()) {

			PromotionsEntity savedPromo = promoRepo.save(entity);

		} else {
			result.put("message", "Please give valid/active pools");
			return result;
		}

		result.put("message", "Promotion mapped succesfully...");
		return result;
	}

	// Method for getting list of Promotions by using flag(Status)
	@Override
	public ResponseEntity<?> getListOfPromotions(String flag) {

		List<PromotionsEntity> promoList = new ArrayList<>();
		try {
			Boolean status = null;
			if (flag.equalsIgnoreCase("true")) {
				status = Boolean.TRUE;
			}
			if (flag.equalsIgnoreCase("false")) {
				status = Boolean.FALSE;
			}
			if (flag.equalsIgnoreCase("all")) {
				promoList = promoRepo.findAll();
			} else {
				promoList = promoRepo.findByIsActive(status);
			}

			List<PromotionsVo> listOfPromo = promoMapper.convertPromoEntityToVo(promoList);
			return new ResponseEntity<>(listOfPromo, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Exception occurs while modifying Promotion", HttpStatus.BAD_REQUEST);
		}
	}

	// Method for modifying/editing Promotion
	@Override
	public String editPromotion(PromotionsVo vo) {

		try {
			Optional<PromotionsEntity> promotion = promoRepo.findById(vo.getPromoId());

			if (promotion.isPresent()) {
				List<ConnectionPoolVo> poolVo = vo.getPoolVo();

				List<Long> poolIds = poolVo.stream().map(x -> x.getPoolId()).collect(Collectors.toList());

				List<PoolEntity> poolList = poolRepo.findByPoolIdInAndIsActive(poolIds, Boolean.TRUE);

				if (poolVo.size() == poolList.size()) {

					PromotionsEntity entity = promoMapper.convertPromoVoToEntity(vo, poolList);
					PromotionsEntity savedPromo = promoRepo.save(entity);

				} else {
					return "Please give valid/active pools";
				}
				return "Promotion Modified succesfully";

			} else {
				return "please give valid Promotion Id";
			}
		} catch (Exception e) {
			return "Exception occurs while modifying Promotion";
		}
	}
}
