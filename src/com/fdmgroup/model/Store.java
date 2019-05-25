package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity(name = "Stores")
@Table(name = "Stores")
public class Store implements IStorable {
	
	@Id
	@Column(name = "store_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_generator")
	@SequenceGenerator(name = "store_generator", sequenceName = "store_id_sequence", allocationSize = 1)
	private int storeId;
	
	@Column(name = "store_name")
	private String storeName;
	
	@Column(name = "store_address")
	private String storeAddress;
	
	@Column(name = "Store_startDate")
	private Date storeStartDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "store_product",
			joinColumns = { @JoinColumn(name = "store_id") },
			inverseJoinColumns = { @JoinColumn(name = "pdt_id") }
			)
	private List<Product> product;
	
	public Store() {
		super();
		product = new ArrayList<Product>();
	}
	
	public List<Product> getProduct() {
		return product;
	}
	public Store setProduct(List<Product> product) {
		this.product = product;
		return this;
	}
	public User getUser() {
		return user;
	}
	public Store setUser(User user) {
		this.user = user;
		return this;
	}
	public int getStoreId() {
		return storeId;
	}
	public Store setStoreId(int storeId) {
		this.storeId = storeId;
		return this;
	}
	public String getStoreName() {
		return storeName;
	}
	public Store setStoreName(String storeName) {
		this.storeName = storeName;
		return this;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public Store setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
		return this;
	}
	public Date getStoreStartDate() {
		return storeStartDate;
	}
	public Store setStoreStartDate(Date storeStartDate) {
		this.storeStartDate = storeStartDate;
		return this;
	}
	
	public void addProduct(Product pro) {
		product.add(pro);
	}
	
	@Transactional
	public void removeProduct(Product pro) {
		product.remove(pro);
	}
	
	@Override
	public String toString() {
		return "Stores [storeId=" + storeId + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", storeStartDate=" + storeStartDate + "]";
	}
	
	
	
}
