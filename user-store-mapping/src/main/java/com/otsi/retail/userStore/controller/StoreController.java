package com.otsi.retail.userStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.retail.userStore.model.StoreModel;
import com.otsi.retail.userStore.service.StoreService;
import com.otsi.retail.userStore.vo.StoreVO;
import com.otsi.retail.userStore.vo.UserVo;


@RestController
@RequestMapping("/stores")
public class StoreController {
	@Autowired
	private StoreService storeService;
	
    //create new store and save the details into DB
	@PostMapping("/store")
	public ResponseEntity<?> addStore(@RequestBody StoreModel storeModel) {
		return storeService.save(storeModel);

	}
   //get the store details  by using storename
	@GetMapping("/store/storename")
	public ResponseEntity<?> getStoreByName(@RequestParam String storeName) {
		return storeService.findByName(storeName);
	}
    //delete the store information  by using id
	@DeleteMapping("/deletestore")
	public ResponseEntity<Object> deleteStoreById(@RequestParam Long id) {
		return storeService.deleteById(id);

	}
	//get all the stores
	@RequestMapping("/getstores")
	public List<StoreVO> getAllStores() {
		return storeService.getAllStores();

	}


}
