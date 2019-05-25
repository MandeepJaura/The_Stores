package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Product;


public interface IProductDao extends ICreatable<Product>, IReadable<Product>, IUpdatable<Product>{
	List<Product> readAll(); 
}
