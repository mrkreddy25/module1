package com.otsi.retail.userStore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.otsi.retail.userStore.model.StoreModel;
import com.otsi.retail.userStore.vo.StoreVO;
//this is the interface here we are writing  all the unimplemented methods
@Service
public interface StoreService {

	ResponseEntity<?> save(StoreModel storeModel);

	ResponseEntity<?> findByName(String storeName);

	ResponseEntity<Object> deleteById(Long id);

	List<StoreVO> getAllStores();

}
