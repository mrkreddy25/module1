package com.otsi.retail.connectionpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.retail.connectionpool.common.CommonRequestMappigs;
import com.otsi.retail.connectionpool.service.PoolService;
import com.otsi.retail.connectionpool.vo.ConnectionPoolVo;

/**
 * This Controller class is for Connection pool related API's
 * 
 * @author Manikanta Guptha
 *
 */
@RestController
@CrossOrigin
@RequestMapping(CommonRequestMappigs.POOL)
public class PoolController {

	@Autowired
	private PoolService poolService;

	// Method for creating pool
	@PostMapping(CommonRequestMappigs.CREATE_POOL)
	public ResponseEntity<?> saveNewPool(@RequestBody ConnectionPoolVo vo) {

		try {

			String savePool = poolService.savePool(vo);
			return new ResponseEntity<>(savePool, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

	// Method for getting List of Pools from status flag
	@GetMapping(CommonRequestMappigs.GET_POOL_LIST)
	public ResponseEntity<?> getListOfPools(@RequestParam String isActive) {

		try {

			ResponseEntity<?> vo = poolService.getListOfPools(isActive);
			return new ResponseEntity<>(vo, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Getting error while fetching the Data", HttpStatus.BAD_REQUEST);
		}
	}

	// Method for modify/editing the Existing Pool and Rules
	@PostMapping(CommonRequestMappigs.MODIFY_POOL)
	public ResponseEntity<?> modifyPool(@RequestBody ConnectionPoolVo vo) {

		try {
			String message = poolService.modifyPool(vo);
			return new ResponseEntity<>(message, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Exception occurs while modifying the record.", HttpStatus.BAD_REQUEST);
		}
	}
}
