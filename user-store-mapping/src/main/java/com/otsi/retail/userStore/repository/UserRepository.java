package com.otsi.retail.userStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.retail.userStore.model.UserModel;
import com.otsi.retail.userStore.vo.UserVo;
//purpose: for accessing database
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	void save(UserVo userVo);

	boolean existsByMobile(String mobile);

	UserModel getById(Long id);

}
