package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Product")
@Table(name = "Product")

public class Product implements IStorable {
	
	@Id
	@Column(name = "pdt_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name = "product_generator", sequenceName = "pdt_id_sequence", allocationSize = 1)
	private int productId;
	
//	@Column(name = "pdt_name")
	@Column(name = "PDT_NAME")
	private String name;
	
	@Column(name = "PDT_DSCE")
	private String description;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "productdate")
	private Date dateTime;
	
	@ManyToMany(mappedBy = "product" ,fetch = FetchType.EAGER)
	private List<Store> stores;
	
	public Product() {
		stores = new ArrayList<Store>();
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	public Product setDateTime(Date dateTime) {
		this.dateTime = dateTime;
		return this;
	}
	public List<Store> getStores() {
		return stores;
	}
	public Product setStores(List<Store> stores) {
		this.stores = stores;
		return this;
	}
	public int getProductId() {
		return productId;
	}
	public Product setProductId(int productId) {
		this.productId = productId;
		return this;
	}
	public String getName() {
		return name;
	}
	public Product setName(String name) {
		this.name = name;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public Product setDescription(String description) {
		this.description = description;
		return this;
	}
	public int getQuantity() {
		return quantity;
	}
	public Product setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	public int getPrice() {
		return price;
	}
	public Product setPrice(int price) {
		this.price = price;
		return this;
	}
	
	public void addStore(Store store) {
		stores.add(store);
	}
	
	public void removeStore(Store store) {
		stores.remove(store);
	}
	@Override
	public String toString() {
		String detail = "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", quantity="
				+ quantity + ", price=" + price + ", dateTime=" + dateTime + " Stores Id " ;
		for(Store s : stores) {
			detail = detail + s.getStoreId() + " , ";
		}
		return detail;
	}
	
}
