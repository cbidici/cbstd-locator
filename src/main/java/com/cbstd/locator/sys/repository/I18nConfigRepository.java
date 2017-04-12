package com.cbstd.locator.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbstd.locator.sys.entity.impl.I18nConfigEntity;

/**
 * Repository interface for i18n configuration
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public interface I18nConfigRepository extends JpaRepository<I18nConfigEntity, Long>, I18nConfigCustomRepository {

	/**
	 * Find i18nConfig by table name and code columns
	 * @param tableName String
	 * @param column String
	 * @param key String
	 * @return i18nConfig I18nConfigEntity
	 * @author cbidici
	 * @since 0.0.1
	 */
	public I18nConfigEntity findByTableNameAndColumnAndKey(String tableName, String column, String key);

}
