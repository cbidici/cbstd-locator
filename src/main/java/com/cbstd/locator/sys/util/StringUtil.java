package com.cbstd.locator.sys.util;

/**
 * Utility class for handling particular reflection operations
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public final class StringUtil {
	
	public final static String EMPTY_STR = "";
	
	/**
	 * Check that if given string is null or empty
	 * @param str String
	 * @return result boolean
	 * @since 0.0.1
	 */
	public final static boolean isNullOrEmpty(String str)
	{
		return null == str || 0 == str.length() ? true : false;
	}
}
