package com.fdmgroup.businessLogic;

import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.jpaDao.UserJpaDao;
import com.fdmgroup.model.User;

public class UserBusinessLogic {
	
	private IUserDao userDao;

	public UserBusinessLogic() {
		this.userDao = new UserJpaDao();
	}

	public User doLogin(String userName, String userPassword) {
		String errMsg = null;
		if(userName == null || userName.trim().length() < 1) {
			errMsg = "User cannot be empty ";
		}
		else if(userPassword == null || userPassword.trim().length() < 1) {
			errMsg = "Password cannot be empty";
		}
		
		if(errMsg != null) {
			throw new IllegalArgumentException(errMsg);
		}
		
		User user = userDao.readByUsername(userName);
		System.out.println(user);
		System.out.println(userName +" "+userPassword);
		if(user == null) {
			errMsg = "User does not exist";
		}else if(!user.getPassword().equals(userPassword)) {
			errMsg = "Incorrect Password";
		}
		if(errMsg != null) {
			throw new IllegalArgumentException(errMsg);
		}
		
		return user;		
	}
}
