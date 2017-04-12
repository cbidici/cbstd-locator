package com.cbstd.locator.service;

import com.cbstd.locator.entity.user.User;

/**
 * User service for user operations
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public interface UserService {

	/**
	 * Save given user to database
	 * 2014-11-29
	 * @param user User
	 * @return user User
	 * @author cbidici
	 * @since 0.0.1
	 */
	public User saveUser(User user);
	
	/**
	 * Load user from database
	 * 2014-11-29
	 * @param userId
	 * @return user User
	 * @author cbidici
	 * @since 0.0.1
	 */
	public User loadByUserId(String userId);
}
