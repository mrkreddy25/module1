package com.otsi.retail.connectionpool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.retail.connectionpool.entity.PromotionsEntity;

@Repository
public interface PromotionRepo extends JpaRepository<PromotionsEntity, Long> {

	List<PromotionsEntity> findByIsActive(Boolean status);
	

}
