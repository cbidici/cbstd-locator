package com.cbstd.locator.sys.service.impl;

import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cbstd.locator.sys.constant.CacheConstants;
import com.cbstd.locator.sys.entity.impl.I18nConfigEntity;
import com.cbstd.locator.sys.repository.I18nConfigRepository;
import com.cbstd.locator.sys.service.I18nConfigService;

/**
 * Implementation for I18nConfigService. This implementation cashes queried remarks 
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
@Service
public class I18nConfigCachedService implements I18nConfigService {

	@Autowired
	I18nConfigRepository i18nConfigRepository;

	@Cacheable(value=CacheConstants.DEFAULT_CACHE_30_DAYS, key="#tableName+#key+#field+#locale.toString()")
	@Transactional
	@Override
	public String getRemark(String tableName, String column, String key, Locale locale) {

		// Query i18nConfig
		I18nConfigEntity i18nConfig = i18nConfigRepository
				.loadI18nConfigByTableNameAndColumnAndKey(tableName, column, key);

		// Get remark from i18nConfig with related locale by using lambda
		// expressions for fun!
		return null == i18nConfig ? null
				: (i18nConfig.getRemarks().stream()
						.filter(r -> r.getLocale().toString().equals(locale.toString())).findAny()
						.isPresent() ? i18nConfig.getRemarks().stream()
						.filter(r -> r.getLocale().toString().equals(locale.toString())).findAny()
						.get().getRemark() : null);

	}

}
