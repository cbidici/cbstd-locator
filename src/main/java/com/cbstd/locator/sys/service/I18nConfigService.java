package com.cbstd.locator.sys.service;

import java.util.Locale;

/**
 * Interface for I18nConfigService
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public interface I18nConfigService {
	
	/**
	 * Get remark for related i18n configuration with given table name and code
	 * @param tableName String
	 * @param column String
	 * @param key String
	 * @param locale Locale
	 * @return remark String
	 * @author cbidici
	 * @since 0.0.1
	 */
	public String getRemark(String tableName, String column, String key, Locale locale);
	
}
