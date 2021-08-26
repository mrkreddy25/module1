//package com.otsi.retail.connectionpool.entity;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity
//@Table(name = "pool_promo")
//@Data
//public class PoolPromoEntity {
//	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "pool_promo", joinColumns = @JoinColumn(name = "promoId"), inverseJoinColumns = @JoinColumn(name = "poolId"))
//	private List<PoolEntity> poolEntity;
//
//}
