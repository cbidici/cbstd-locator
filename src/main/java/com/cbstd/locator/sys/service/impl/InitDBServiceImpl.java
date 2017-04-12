package com.cbstd.locator.sys.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbstd.locator.entity.Permission;
import com.cbstd.locator.entity.user.BasicUser;
import com.cbstd.locator.entity.user.User;
import com.cbstd.locator.repository.PermissionRepository;
import com.cbstd.locator.service.UserService;
import com.cbstd.locator.sys.entity.impl.I18nConfigEntity;
import com.cbstd.locator.sys.entity.impl.I18nRemarkEntity;
import com.cbstd.locator.sys.entity.impl.StatusEntity;
import com.cbstd.locator.sys.enums.StatusEnum;
import com.cbstd.locator.sys.repository.I18nConfigRepository;
import com.cbstd.locator.sys.repository.I18nRemarkRepository;
import com.cbstd.locator.sys.repository.StatusRepository;
import com.cbstd.locator.sys.service.InitDBService;

/**
 * Data initiation service
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
@Transactional
@Service
public class InitDBServiceImpl implements InitDBService{

	@Autowired
	PermissionRepository permissionRepository;
	
	@Autowired
	I18nConfigRepository i18nConfigRepository;
	
	@Autowired
	I18nRemarkRepository i18nRemarkRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	UserService userService;
	
	@PostConstruct
	@Override
	public void init() {
		
		// First User
		Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		BasicUser basicUser = new BasicUser();
		basicUser.setCreateDate(ts);
		basicUser.setEmail("cbidici@gmail.com");
		basicUser.setPassword("112233");
		basicUser.setUsername("cbidici");
		basicUser.setVerified(true);
		
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		System.out.println("Generated User ID :" + user.getUserId());
		user.setCreateDate(ts);
		user.setBasicUser(basicUser);
		
		basicUser.setUser(user);
		
		userService.saveUser(user);
		
		System.out.println(user.getUserId());
		
		StatusEntity status0 = new StatusEntity();
		status0.setId(StatusEnum.ACTIVE);
		status0.setName("Active Status Name");
		status0.setDescription("Active status Description");
		statusRepository.save(status0);
		
		StatusEntity status1 = new StatusEntity();
		status1.setId(StatusEnum.DEACTIVE);
		status1.setName("Deactive Status Name");
		status1.setDescription("Deactive status Description");
		statusRepository.save(status1);
		
		StatusEntity status2 = new StatusEntity();
		status2.setId(StatusEnum.DELETED);
		status2.setName("Deleted Status Name");
		status2.setDescription("Deleted status Description");
		statusRepository.save(status2);
		
		Permission pLogin = new Permission();
		pLogin.setCode("SP000001");
		pLogin.setName("System login permission.");
		pLogin.setDescription("This permission enables to login for self registered uses.");
		pLogin.setStatus(status0);
		permissionRepository.save(pLogin);
		
		I18nConfigEntity pLoginI18nConfigName = new I18nConfigEntity();
		pLoginI18nConfigName.setKey("SP000001");
		pLoginI18nConfigName.setTableName("loc_permission");
		pLoginI18nConfigName.setColumn("name");
		pLoginI18nConfigName.setRemarks(new ArrayList<I18nRemarkEntity>());
		pLoginI18nConfigName.setStatus(status0);
		i18nConfigRepository.save(pLoginI18nConfigName);
		
		I18nRemarkEntity remarkName1 = new I18nRemarkEntity();
		remarkName1.setLocale(Locale.US);
		remarkName1.setRemark("US Remark");
		remarkName1.setI18nConfig(pLoginI18nConfigName);
		remarkName1.setStatus(status0);
		i18nRemarkRepository.save(remarkName1);
		
		I18nRemarkEntity remarkName2 = new I18nRemarkEntity();
		remarkName2.setLocale(new Locale("tr_TR"));
		remarkName2.setRemark("TR Remark");
		remarkName2.setI18nConfig(pLoginI18nConfigName);
		remarkName2.setStatus(status0);
		i18nRemarkRepository.save(remarkName2);
		
		I18nConfigEntity pLoginI18nConfigDescription = new I18nConfigEntity();
		pLoginI18nConfigDescription.setKey("SP000001");
		pLoginI18nConfigDescription.setTableName("loc_permission");
		pLoginI18nConfigDescription.setColumn("description");
		pLoginI18nConfigDescription.setRemarks(new ArrayList<I18nRemarkEntity>());
		pLoginI18nConfigDescription.setStatus(status0);
		i18nConfigRepository.save(pLoginI18nConfigDescription);
		
		I18nRemarkEntity remarkDescription1 = new I18nRemarkEntity();
		remarkDescription1.setLocale(Locale.US);
		remarkDescription1.setRemark("US Remark");
		remarkDescription1.setI18nConfig(pLoginI18nConfigDescription);
		remarkDescription1.setStatus(status0);
		i18nRemarkRepository.save(remarkDescription1);
		
		I18nRemarkEntity remark2Description = new I18nRemarkEntity();
		remark2Description.setLocale(new Locale("tr_TR"));
		remark2Description.setRemark("TR Remark");
		remark2Description.setI18nConfig(pLoginI18nConfigDescription);
		remark2Description.setStatus(status0);
		i18nRemarkRepository.save(remark2Description);
		
	}
	
}
