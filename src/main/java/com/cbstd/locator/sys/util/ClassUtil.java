package com.cbstd.locator.sys.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;

import com.cbstd.locator.sys.constant.CacheConstants;

/**
 * Utility class for handling particular reflection operations
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public final class ClassUtil {

	/**
	 * Get declared field list of a class including fields from super class
	 * 2014-11-29
	 * @param clazz Class<?>
	 * @return fields List<Field>
	 * @author cbidici
	 * @since 0.0.1
	 */
	@Cacheable(value = CacheConstants.DEFAULT_CACHE_30_DAYS, key = "#clazz.getName()")
	public final static List<Field> getDeclaredFields(Class<?> clazz) {
		
		List<Field> fields = new LinkedList<Field>();
		
		// Get fields
		Field[] declaredFields = clazz.getDeclaredFields();
		Collections.addAll(fields, declaredFields);

		// Get fields of super class if exists
		Class<?> superClass = clazz.getSuperclass();
		if (superClass != null) {
			fields.addAll(getDeclaredFields(superClass));
		}

		return fields;
	}

	/**
	 * Get annotated fields of a class with given annotation class
	 * @param clazz Class<?>
	 * @param annotationClass Class<? extends Annotation>
	 * @return annotatedFields List<Field>
	 * @since 0.0.1
	 */
	@Cacheable(value = CacheConstants.DEFAULT_CACHE_30_DAYS, key = "#clazz.getName()+#annotationClass.getName()")
	public final static List<Field> getAnnotatedFields(Class<?> clazz,
			Class<? extends Annotation> annotationClass) {
		
		// Get declared fields of class
		List<Field> allFields = getDeclaredFields(clazz);

		// Return fields which annotated bu given annotation
		return allFields.stream()
				.filter(f -> f.isAnnotationPresent(annotationClass))
				.collect(Collectors.toList());

	}

}
