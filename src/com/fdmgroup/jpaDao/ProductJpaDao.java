package com.fdmgroup.jpaDao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.dao.IProductDao;
import com.fdmgroup.model.Product;

public class ProductJpaDao implements IProductDao {

private DbConnection connection;
	
	public ProductJpaDao() {
		super();
		connection = DbConnection.getInstance();
	}

	@Override
	public boolean create(Product product) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	@Override
	public Product readById(int id) {
		EntityManager em = connection.getEntityManager();
		Product product = em.find(Product.class, id);
		return product;
	}


	@Override
	public boolean update(Product product) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	@Override
	public List<Product> readAll() {
		EntityManager em = connection.getEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<Product> allProduct = em.createQuery("SELECT distinct p FROM Product as p inner join p.stores ", Product.class);
		List<Product> product = allProduct.getResultList();
		em.getTransaction().commit();
		em.close();
		return product;
	}


}

	

