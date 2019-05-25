package com.fdmgroup.businessLogic;

import java.util.Date;
import com.fdmgroup.dao.IProductDao;
import com.fdmgroup.dao.IStoreDao;
import com.fdmgroup.jpaDao.ProductJpaDao;
import com.fdmgroup.jpaDao.StoreJpaDao;
import com.fdmgroup.model.Product;
import com.fdmgroup.model.Store;

public class ProductBusinessLogin {
	private IProductDao productDao;
	private IStoreDao storeDao;
	
	
	public ProductBusinessLogin() {
		super();
		productDao = new ProductJpaDao();
		storeDao = new StoreJpaDao();
	}

	public void insertProduct(String productName, String price, String quantity, String desc,String Id) {
		
		int storeId = Integer.parseInt(Id);
		int productQuantity = Integer.parseInt(quantity);
		int productPrice = Integer.parseInt(price);
		
		Product newProduct = new Product().setName(productName).setQuantity(productQuantity).setPrice(productPrice).setDescription(desc).setDateTime(new Date());
		productDao.create(newProduct);
		Store store = storeDao.readById(storeId);
		store.addProduct(newProduct);
		storeDao.update(store);
	}
	
	public void updateProductInformation(String productName, String price, String quantity, String desc,String Id) {
		int productId = Integer.parseInt(Id);
		int productQuantity = Integer.parseInt(quantity);
		int productPrice = Integer.parseInt(price);
		
		Product selectProduct = productDao.readById(productId);
		
		selectProduct.setName(productName).setPrice(productPrice).setQuantity(productQuantity).setDescription(desc).setDateTime(new Date());
		
		productDao.update(selectProduct);
	}
	
	public void deleteProductFromStore(String sId, String pId) {
		int productId = Integer.parseInt(pId);
		int storeId = Integer.parseInt(sId);
		storeDao.removeProductFromStore(storeId, productId);;
		
	}
}
