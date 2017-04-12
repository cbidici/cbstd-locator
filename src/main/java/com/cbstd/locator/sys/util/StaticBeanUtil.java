package com.cbstd.locator.sys.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cbstd.locator.sys.service.I18nConfigService;

/**
 * Utility class to access particular services in a static way
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */

@Component
public class StaticBeanUtil {

	/**
	 * Static reference to i18n_config_service
	 */
	public static I18nConfigService I18N_CONFIG_SERVICE;
	
	/**
	 * Static reference to hibernate session factory
	 */
	public static SessionFactory SESSION_FACTORY;
	
	@Autowired
    public void setI18nConfigService(I18nConfigService i18nConfigService){
		StaticBeanUtil.I18N_CONFIG_SERVICE = i18nConfigService;
    }
	
	@Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
		StaticBeanUtil.SESSION_FACTORY = sessionFactory;
    }
	
}
