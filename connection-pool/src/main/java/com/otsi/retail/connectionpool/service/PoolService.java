package com.otsi.retail.connectionpool.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.otsi.retail.connectionpool.vo.ConnectionPoolVo;

/**
 * This interface is implemented by PoolServiceImpl
 * 
 * @author Manikanta Guptha
 *
 */
@Component
public interface PoolService {

	String savePool(ConnectionPoolVo vo);

	ResponseEntity<?> getListOfPools(String isActive);

	String modifyPool(ConnectionPoolVo vo);

}
