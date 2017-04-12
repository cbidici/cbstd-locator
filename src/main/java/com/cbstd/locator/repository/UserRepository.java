package com.cbstd.locator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbstd.locator.entity.user.User;

/**
 * Repository for User
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserId(String userId);
}
