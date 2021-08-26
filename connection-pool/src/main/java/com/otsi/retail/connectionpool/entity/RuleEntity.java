package com.otsi.retail.connectionpool.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.otsi.retail.connectionpool.common.ColumnName;
import com.otsi.retail.connectionpool.common.Operator;

import lombok.Data;

@Data
@Entity
//@Table(name = "poolRule")
public class RuleEntity {

	@Id
	@GeneratedValue
	private Long ruleId;

	private ColumnName columnName;

	private Operator operatorSymbol;

	private Long givenValue;

	@ManyToOne
	@JoinColumn(name = "pool_Id")
	private PoolEntity poolEntity;

}
