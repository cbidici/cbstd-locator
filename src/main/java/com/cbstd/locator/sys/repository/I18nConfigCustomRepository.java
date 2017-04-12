package com.cbstd.locator.sys.repository;

import com.cbstd.locator.sys.entity.impl.I18nConfigEntity;

/**
 * Interface to extend default i18n configuration repository behavior
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public interface I18nConfigCustomRepository {
	
	/**
	 * Load i18nConfig by table name and code columns with remarks
	 * @param tableName String
	 * @param column String
	 * @param key String
	 * @return i18nConfig I18nConfigEntity
	 * @author cbidici
	 * @since 0.0.1
	 */
	public I18nConfigEntity loadI18nConfigByTableNameAndColumnAndKey(String tableName, String column, String key);
}
