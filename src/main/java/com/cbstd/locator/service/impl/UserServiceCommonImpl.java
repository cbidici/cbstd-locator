package com.cbstd.locator.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cbstd.locator.entity.user.User;
import com.cbstd.locator.repository.BasicUserRepository;
import com.cbstd.locator.repository.UserRepository;
import com.cbstd.locator.service.UserService;

/**
 * Common user detail service
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
@Service(value="userService")
public class UserServiceCommonImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BasicUserRepository basicUserRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		throw new UsernameNotFoundException("");  
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		
		Assert.notNull(user);
		
		prepareUserToSave(user);
		
		userRepository.save(user);
		
		if(null != user.getBasicUser())
		{
			user.getBasicUser().setUser(user);
			basicUserRepository.save(user.getBasicUser());
		}
		
		return user;
	}

	@Override
	@Transactional
	public User loadByUserId(String userId) {
		
		User user = userRepository.findByUserId(userId);
		Hibernate.initialize(user.getBasicUser());
		Hibernate.initialize(user.getRoles());
		return user;
		
	}
	
	/**
	 * Prepare user before saving it to database
	 * @param user User
	 * @author cbidici
	 * @since 0.0.1
	 */
	private void prepareUserToSave(User user)
	{
		// Query user with userId to find out if user exists 
		User userDB = userRepository.findByUserId(user.getUserId());
		
		// If user does exist set required attributes for update
		if (null != userDB) {
			user.setId(userDB.getId());
			user.setUserId(userDB.getUserId());
			
			if(null != user.getBasicUser() && null != userDB.getBasicUser() ){
				user.getBasicUser().setPassword(userDB.getBasicUser().getPassword());
			}
			
		}
		// If user does not exist set required attrites for insert
		else {
			Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());
			
			user.setUserId(UUID.randomUUID().toString());
			user.setCreateDate(ts);
			user.getBasicUser().setPassword(passwordEncoder.encode(user.getBasicUser().getPassword()));
			user.getBasicUser().setCreateDate(ts);
		}
	}
	
}
