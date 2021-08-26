package com.otsi.retail.connectionpool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.retail.connectionpool.entity.PoolEntity;


@Repository
public interface PoolRepo extends JpaRepository<PoolEntity, Long> {

	List<PoolEntity> findByIsActive(Boolean isActive);

	List<PoolEntity> findByPoolIdInAndIsActive(List<Long> poolIds, Boolean true1);

}
