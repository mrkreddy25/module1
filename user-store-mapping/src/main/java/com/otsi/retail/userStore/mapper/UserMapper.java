package com.otsi.retail.userStore.mapper;

import org.springframework.stereotype.Component;

import com.otsi.retail.userStore.model.StoreModel;
import com.otsi.retail.userStore.model.UserModel;
import com.otsi.retail.userStore.vo.StoreVO;
import com.otsi.retail.userStore.vo.UserVo;

//purpose of this class is to convert the (entity to vo )and (vo to entity) objects

@Component
public class UserMapper {

	// this method is used to convert entity object to vo object
	public UserVo mapEntityToVo(UserModel user) {
		UserVo responseVo = new UserVo();
		responseVo.setId(user.getId());
		responseVo.setName(user.getName());
		responseVo.setEmail(user.getEmail());
		responseVo.setMobile(user.getMobile());
		responseVo.setAllowedIps(user.getAllowedIps());
		responseVo.setStatus(user.getStatus());
		responseVo.setActions(user.getActions());
		responseVo.setStores(user.getStores());

		return responseVo;

	}

	// this method is used to convert vo object to entity object
	public void mapVoToEntity(UserVo userVo, UserModel user) {

		user.setId(userVo.getId());
		user.setName(userVo.getName());
		user.setEmail(userVo.getEmail());
		user.setMobile(userVo.getMobile());
		user.setAllowedIps(userVo.getAllowedIps());
		user.setStatus(userVo.getStatus());
		user.setActions(userVo.getActions());

		user.setStores(userVo.getStores());

	}

	// to convert store entity object to vo object
	public StoreVO convertEntityToVolist(StoreModel list) {

		StoreVO responseStoreVo = new StoreVO();
		responseStoreVo.setId(list.getId());
		responseStoreVo.setStoreName(list.getStoreName());
		responseStoreVo.setUsers(list.getUsers());

		return responseStoreVo;
	}

}
