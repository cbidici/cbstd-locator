package com.cbstd.locator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.cbstd.locator.entity.Permission;
import com.cbstd.locator.repository.PermissionRepository;
import com.cbstd.locator.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionRepository permissionRepository;
	
	@Override
	@Secured("hasAuthority('PERMISSION_QUERY_BY_CODE')")
	public Permission findByCode(String code) {
		return permissionRepository.findByCode(code);
	}

}
