package com.cbstd.locator.sys.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to localize text fields. string value should contain attribute name for i18n configuration key
 * with which field value. Annotated filed will not be created 
 * 2014-11-29
 * @author cbidici
 * @since
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AddI18n {
	public String value();
}
