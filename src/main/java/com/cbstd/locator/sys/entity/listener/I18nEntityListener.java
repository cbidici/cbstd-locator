package com.cbstd.locator.sys.entity.listener;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.PostLoad;

import org.apache.log4j.Logger;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.context.i18n.LocaleContextHolder;

import com.cbstd.locator.sys.annotation.AddI18n;
import com.cbstd.locator.sys.util.ClassUtil;
import com.cbstd.locator.sys.util.StaticBeanUtil;
import com.cbstd.locator.sys.util.StringUtil;

/**
 * I18nEntityListener class stands for setting i18ned fields to local texts
 * 2014-12-13
 * @author cbidici
 * @since 0.0.1
 */
public class I18nEntityListener {

	/**
	 * Logger
	 */
	private static final Logger LOG = Logger.getLogger(I18nEntityListener.class);
	
	/**
	 * Load local texts after object loaded from database
	 * @param obj Object
	 * @author cbidici
	 * @since 0.0.1
	 */
	@PostLoad
	public void setI18nFields(Object obj) {

		try {

			// Get table name
			String tableName = ((AbstractEntityPersister) StaticBeanUtil.SESSION_FACTORY
					.getClassMetadata(obj.getClass())).getTableName();

			// Get annotated fields
			List<Field> annotatedFields = ClassUtil.getAnnotatedFields(
					obj.getClass(), AddI18n.class);

			// For every annotated field
			for (Field annotatedField : annotatedFields) {
				
				String columnName =  ((AbstractEntityPersister) StaticBeanUtil.SESSION_FACTORY.getClassMetadata(obj.getClass())).getPropertyColumnNames(annotatedField.getName())[0];
				
				
				String i18nKeyFieldName = annotatedField.getAnnotation(
						AddI18n.class).value();

				// Get all fields of class
				List<Field> fieldList = new ArrayList<Field>();
				Collections.addAll(fieldList, obj.getClass().getDeclaredFields());

				// Find the field which is given to annotated field as parameter
				Field keyField = fieldList.stream()
						.filter(f -> f.getName().equals(i18nKeyFieldName))
						.findAny().get();
				
				keyField.setAccessible(true);
				
				String keyValue = keyField.get(obj).toString();

				// Get remark from DB
				String remark = StaticBeanUtil.I18N_CONFIG_SERVICE.getRemark(
						tableName, columnName, keyValue, LocaleContextHolder.getLocale());

				if (!StringUtil.isNullOrEmpty(remark)) {
					annotatedField.setAccessible(true);
					annotatedField.set(obj, remark);
				}

			}
		} catch (Exception e) {
			LOG.error(e);
		}
	}
}
