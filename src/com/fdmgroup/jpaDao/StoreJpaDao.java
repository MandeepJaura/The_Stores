package com.fdmgroup.jpaDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.fdmgroup.dao.IStoreDao;
import com.fdmgroup.model.Product;
import com.fdmgroup.model.Store;
import com.fdmgroup.model.User;





public class StoreJpaDao implements IStoreDao  {

private DbConnection connection;
	
	public StoreJpaDao( ) {
		super();
		connection = DbConnection.getInstance();
	}

	@Override
	public boolean create(Store store) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(store);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public Store readById(int id) {
		EntityManager em = connection.getEntityManager();
		Store stores = em.find(Store.class, id);
		em.close();
		return stores;
	}

	@Override
	public boolean delete(Store store) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.contains(store) ? store: em.merge(store));
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean update(Store store) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.merge(store);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Store> readAll() {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Store> allStores = em.createQuery("SELECT s FROM Stores s", Store.class );
		List<Store> stores = allStores.getResultList();
		em.getTransaction().commit();
		em.close();
		return stores;
	}

	@Override
	public List<Store> findStoresWithLoggedInUserId(User user) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Store> allStores = em.createQuery("SELECT s FROM Stores s WHERE user_id=:user_id", Store.class );
		allStores.setParameter("user_id", user.getUserId());
		List<Store> stores = allStores.getResultList();
		em.getTransaction().commit();
		em.close();
		return stores;
		
	}

	@Override
	public void insertProduct(Store store) {
//		EntityManager em = connection.getEntityManager();
//		em.getTransaction().begin();
//		em.remove(store);
//		em.getTransaction().commit();
	}
	
	@Override
	public void removeProductFromStore(int storeId, int productId) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		Store store = em.find(Store.class, storeId);
		Product product = em.find(Product.class, productId);
		
		System.out.println(store);
		System.out.println(product);
		
		store.getProduct().remove(product);
		
		em.merge(store);
		em.getTransaction().commit();
		em.close();
	}

}
