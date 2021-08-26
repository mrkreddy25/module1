package com.otsi.retail.connectionpool.vo;

import org.springframework.stereotype.Component;

import com.otsi.retail.connectionpool.common.ColumnName;
import com.otsi.retail.connectionpool.common.Operator;

import lombok.Data;

@Component
@Data
public class RuleVo {

	private ColumnName columnName;

	private Operator operatorSymbol;

	private Long givenValue;

	private Long ruleId;

}
