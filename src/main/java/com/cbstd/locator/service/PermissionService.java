package com.cbstd.locator.service;

import com.cbstd.locator.entity.Permission;

/**
 * Permission operations
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public interface PermissionService {

	Permission findByCode(String string);

}
