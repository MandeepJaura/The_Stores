package com.fdmgroup.businessLogic;

import java.util.Date;
import java.util.List;

import com.fdmgroup.dao.IStoreDao;
import com.fdmgroup.jpaDao.StoreJpaDao;
import com.fdmgroup.model.Product;
import com.fdmgroup.model.Store;
import com.fdmgroup.model.User;

public class StoreBusinessLogin {
	private IStoreDao storeDao;
	
	
	
	public StoreBusinessLogin() {
		super();
		storeDao = new StoreJpaDao();
	}
	
	public List<Store> getStoresOfLoggedInUser(User user){
		List<Store> stores = storeDao.findStoresWithLoggedInUserId(user);
		return stores;
	}
	
	public boolean insertStore(String storeName, String storeAddress,User user) {
		Store store = new Store().setStoreName(storeName).setStoreAddress(storeAddress).setStoreStartDate(new Date()).setUser(user);
		
		storeDao.create(store);
		 return true;
	}
	
	public boolean updateStoreInformation(String storeId,String storeName, String storeAddress) {
		int convertedStoreId = Integer.parseInt(storeId);
		Store selectedStores = storeDao.readById(convertedStoreId);
		selectedStores.setStoreName(storeName).setStoreAddress(storeAddress).setStoreStartDate(new Date());
		storeDao.update(selectedStores);
		return true;
		
	}
	
	public List<Product> productOfSelectedStore(String storeId){
		int convertedStoreId = Integer.parseInt(storeId);
		Store selectedStores = storeDao.readById(convertedStoreId);
		
		List<Product> productListOfSelectedStore = selectedStores.getProduct();
		return productListOfSelectedStore;
		
	}
	
	public List<Store> allStoresForUser(){
		List<Store> stores = storeDao.readAll();
		return stores;
	}
}
