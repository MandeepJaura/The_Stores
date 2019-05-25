package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Store;
import com.fdmgroup.model.User;



public interface IStoreDao extends ICreatable<Store>, IReadable<Store>,IDeletable<Store>, IUpdatable<Store>{
	List<Store> readAll();
	List<Store> findStoresWithLoggedInUserId(User user);
	public void insertProduct(Store store);
	void removeProductFromStore(int storeId, int product_id);
}
