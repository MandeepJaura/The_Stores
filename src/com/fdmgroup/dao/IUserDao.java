package com.fdmgroup.dao;

import com.fdmgroup.model.User;

public interface IUserDao extends ICreatable<User>, IReadable<User> {
	User readByUsername(String username);
	void update(String userName, String oldPassword, String newPassword,String email );
	User readByEmail(String email);
}
