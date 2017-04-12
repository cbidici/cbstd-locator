package com.cbstd.locator.sys.repository.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;

import com.cbstd.locator.sys.entity.impl.I18nConfigEntity;
import com.cbstd.locator.sys.repository.I18nConfigCustomRepository;
import com.cbstd.locator.sys.repository.I18nConfigRepository;

/**
 * Class to implement extended behavior if i18n configuration repository
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public class I18nConfigRepositoryImpl implements I18nConfigCustomRepository{

	@Autowired
	I18nConfigRepository i18nConfigRepository;

	@Override
	public I18nConfigEntity loadI18nConfigByTableNameAndColumnAndKey(String tableName,
			String column, String key) {
		
		// Find i18nConfig by table name and code columns
		I18nConfigEntity i18nConfig = i18nConfigRepository.findByTableNameAndColumnAndKey(tableName, column, key);
		
		// Force load of remarks
		Hibernate.initialize(i18nConfig.getRemarks());
		
		return i18nConfig;
	}

}
