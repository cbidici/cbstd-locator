package com.cbstd.locator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbstd.locator.entity.Permission;

/**
 * Repository interface for permission
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {

	/**
	 * Find permission by permission code
	 * @param code String
	 * @return permission Permission
	 * @author cbidici
	 * @since 0.0.1
	 */
	public Permission findByCode(String code);
}
