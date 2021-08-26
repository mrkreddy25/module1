package com.otsi.retail.connectionpool.vo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.otsi.retail.connectionpool.common.PoolType;

import lombok.Data;

@Component
@Data
public class ConnectionPoolVo {

	private String poolName;

	private Long poolId;

	private PoolType poolType;

	private List<RuleVo> ruleVo;

	private LocalDate createdDate;

	private LocalDate lastModified;

	private Boolean isActive;

	private Boolean isForEdit;

}
