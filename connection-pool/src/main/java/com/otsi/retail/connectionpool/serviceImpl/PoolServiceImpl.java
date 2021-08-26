package com.otsi.retail.connectionpool.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.otsi.retail.connectionpool.entity.PoolEntity;
import com.otsi.retail.connectionpool.mapper.PoolMapper;
import com.otsi.retail.connectionpool.repository.PoolRepo;
import com.otsi.retail.connectionpool.repository.RuleRepo;
import com.otsi.retail.connectionpool.service.PoolService;
import com.otsi.retail.connectionpool.vo.ConnectionPoolVo;

/**
 * This class having Bussiness logics for all pool services
 * 
 * @author Manikanta Guptha
 *
 */
@Service
public class PoolServiceImpl implements PoolService {

	@Autowired
	private PoolMapper poolMapper;

	@Autowired
	private PoolRepo poolRepo;

	@Autowired
	private RuleRepo ruleRepo;

	// Method for saving pools from Connection VO
	@Override
	public String savePool(ConnectionPoolVo vo) {

		try {
			PoolEntity poolEntity = poolMapper.convertPoolVoToEntity(vo);

			PoolEntity savedPool = poolRepo.save(poolEntity);

			poolEntity.getRuleEntity().forEach(x -> {

				x.setPoolEntity(savedPool);
				ruleRepo.save(x);
			});

			return "Pool saved Successfully";

		} catch (Exception e) {
			return "Exception occurs while saving the Pool";
		}
	}

	// Method for getting list of pools based on the status flag
	@Override
	public ResponseEntity<?> getListOfPools(String isActive) {
		try {
			List<PoolEntity> poolEntity = new ArrayList<>();
			Boolean flag = null;

			if (isActive.equalsIgnoreCase("true")) {
				flag = Boolean.TRUE;
			}
			if (isActive.equalsIgnoreCase("false")) {
				flag = Boolean.FALSE;
			}

			if (isActive.equalsIgnoreCase("ALL")) {
				poolEntity = poolRepo.findAll();
			} else {
				poolEntity = poolRepo.findByIsActive(flag);
			}
			if (!poolEntity.isEmpty()) {

				List<ConnectionPoolVo> poolVo = poolMapper.convertPoolEntityToVo(poolEntity);
				return new ResponseEntity<>(poolVo, HttpStatus.OK);

			} else {
				return new ResponseEntity<>("No data found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Getting error while fetching data", HttpStatus.BAD_GATEWAY);
		}
	}

	// Method for Modifying/Edit the existing pool details
	@Override
	public String modifyPool(ConnectionPoolVo vo) {

		try {

			Optional<PoolEntity> pool = poolRepo.findById(vo.getPoolId());

			if (!pool.isPresent()) {

				PoolEntity poolEntity = poolMapper.convertPoolVoToEntity(vo);

				poolEntity.setPoolId(vo.getPoolId());
				poolEntity.setLastModified(LocalDate.now());

				PoolEntity savedPool = poolRepo.save(poolEntity);

			} else {
				return "Invalid Pool Id";
			}
			return "Pool Modified Successfully...";
		} catch (Exception e) {
			return "Exception occurs while modifying the record.";
		}
	}
}
