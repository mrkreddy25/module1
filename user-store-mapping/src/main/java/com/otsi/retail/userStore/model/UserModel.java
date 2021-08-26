package com.otsi.retail.userStore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Name;
	@Column(unique = true)
	private String Email;
	private String mobile;
	private String AllowedIps;
	private String Status;
	private String Actions;
	//many to many mapping happens for user ang store tables
	@ManyToMany(targetEntity = StoreModel.class, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinTable(name = "user_store", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "StoreId", referencedColumnName = "id"))
	private List<StoreModel> stores;

	public UserModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public UserModel(Long id, String name, String email, String mobile, String allowedIps, String status,
			String actions, List<StoreModel> stores) {
		super();
		this.id = id;
		Name = name;
		Email = email;
		this.mobile = mobile;
		AllowedIps = allowedIps;
		Status = status;
		Actions = actions;
		this.stores = stores;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAllowedIps() {
		return AllowedIps;
	}

	public void setAllowedIps(String allowedIps) {
		AllowedIps = allowedIps;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getActions() {
		return Actions;
	}

	public void setActions(String actions) {
		Actions = actions;
	}
	public List<StoreModel> getStores() {
		return stores;
	}

	public void setStores(List<StoreModel> stores) {
		this.stores = stores;
	}

	public void addStore(StoreModel store) {
		// TODO Auto-generated method stub
		this.stores.add(store);
		store.getUsers().add(this);
	}

	public void removeStores(StoreModel store) {
		this.getStores().remove(store);
		store.getUsers().remove(this);
	}

	public void removeStores() {
		for (StoreModel store : new ArrayList<>(stores)) {
			removeStores(store);
		}
	}

}
