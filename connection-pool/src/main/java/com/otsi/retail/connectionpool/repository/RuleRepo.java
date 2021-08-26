package com.otsi.retail.connectionpool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otsi.retail.connectionpool.entity.PoolEntity;
import com.otsi.retail.connectionpool.entity.RuleEntity;

@Repository
public interface RuleRepo extends JpaRepository<RuleEntity, Long> {

	//List<RuleEntity> findByPoolId(PoolEntity savedPool);

	List<RuleEntity> findByRuleIdIn(List<Long> ruleIdList);

	// List<RuleEntity> findByPoolId(Long poolId);

}
