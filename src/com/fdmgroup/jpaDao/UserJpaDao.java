package com.fdmgroup.jpaDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.User;

public class UserJpaDao implements IUserDao {

	private DbConnection connection =  DbConnection.getInstance();
	
	@Override
	public boolean create(User user) {
		EntityManager em = connection.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		
		return true;
	}

	@Override
	public User readById(int id) {
		EntityManager em = connection.getEntityManager();
		User user = em.find(User.class, id);
		em.close();
		return user;
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readByUsername(String username) {
		EntityManager em = connection.getEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<User> selectUser = em.createQuery("SELECT u FROM User u where user_name =:username ", User.class );
		selectUser.setParameter("username", username);
		List<User> user = selectUser.getResultList();
		em.getTransaction().commit();
		em.close();
		
		if(user.size() != 0) {
			return user.get(0);
		}else {
			return null;
		}
		
	}
	
	@Override
	public void update(String userName, String oldPassword, String newPassword,String email ) {
		EntityManager em = connection.getEntityManager();
		System.out.println("Update Method");
		em.getTransaction().begin();
		Query updateUser = em.createQuery("Update User u Set pasword =:newpassword, email=:email Where user_name =:username and pasword =:oldpassword " );
		updateUser.setParameter("username", userName);
		updateUser.setParameter("newpassword", newPassword);
		updateUser.setParameter("oldpassword", oldPassword);
		updateUser.setParameter("email", email);
		updateUser.executeUpdate();
		em.getTransaction().commit();
		em.close();

	}
	@Override
	public User readByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
