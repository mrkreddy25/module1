package com.otsi.retail.connectionpool.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.otsi.retail.connectionpool.common.PoolType;

import lombok.Data;

@Data
@Entity
@Table(name = "pool")
public class PoolEntity {

	@Id
	@GeneratedValue
	private Long poolId;

	private String poolName;

	private PoolType poolType;

	private LocalDate createdDate;

	private LocalDate lastModified;

	private Boolean isActive;

	@OneToMany(targetEntity = RuleEntity.class, mappedBy = "poolEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RuleEntity> ruleEntity;
	
	@ManyToMany(mappedBy = "poolEntity",cascade = CascadeType.ALL)
	private List<PromotionsEntity> promoEntity;
	
	
	
	

//	@ManyToMany
//	@JoinTable(name = "pool_promo", joinColumns = { @JoinColumn(name = "poolId") }, inverseJoinColumns = {
//			@JoinColumn(referencedColumnName = "promoId") })
//	private List<PromotionsEntity> promoEntity;

}
