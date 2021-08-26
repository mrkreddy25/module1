package com.otsi.retail.connectionpool.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.otsi.retail.connectionpool.entity.PoolEntity;
import com.otsi.retail.connectionpool.entity.RuleEntity;
import com.otsi.retail.connectionpool.vo.ConnectionPoolVo;
import com.otsi.retail.connectionpool.vo.RuleVo;

@Component
public class PoolMapper {

	public PoolEntity convertPoolVoToEntity(ConnectionPoolVo vo) {

		PoolEntity ent = new PoolEntity();

		ent.setPoolName(vo.getPoolName());
		ent.setPoolType(vo.getPoolType());
		ent.setCreatedDate(LocalDate.now());
		ent.setLastModified(LocalDate.now());
		ent.setIsActive(Boolean.TRUE);

		List<RuleEntity> ruleEntity = new ArrayList<>();

		vo.getRuleVo().stream().forEach(x -> {

			RuleEntity entity = new RuleEntity();
			if (vo.getIsForEdit()) {

				entity.setRuleId(x.getRuleId());
				entity.setPoolEntity(ent);
			}

			entity.setColumnName(x.getColumnName());
			entity.setOperatorSymbol(x.getOperatorSymbol());
			entity.setGivenValue(x.getGivenValue());

			ruleEntity.add(entity);
		});
		ent.setRuleEntity(ruleEntity);

		return ent;
	}

	public List<ConnectionPoolVo> convertPoolEntityToVo(List<PoolEntity> poolEntity) {

		List<ConnectionPoolVo> listOfPool = new ArrayList<>();

		poolEntity.stream().forEach(x -> {

			ConnectionPoolVo vo = new ConnectionPoolVo();

			vo.setPoolName(x.getPoolName());
			vo.setPoolId(x.getPoolId());
			vo.setCreatedDate(x.getCreatedDate());
			vo.setPoolType(x.getPoolType());
			vo.setIsActive(x.getIsActive());
			vo.setLastModified(x.getLastModified());
			listOfPool.add(vo);

			List<RuleVo> ruleVo = new ArrayList<>();

			x.getRuleEntity().stream().forEach(a -> {
				RuleVo rule = new RuleVo();

				rule.setRuleId(a.getRuleId());
				rule.setColumnName(a.getColumnName());
				rule.setOperatorSymbol(a.getOperatorSymbol());
				rule.setGivenValue(a.getGivenValue());

				ruleVo.add(rule);

			});
			vo.setRuleVo(ruleVo);

		});

		return listOfPool;
	}

}
