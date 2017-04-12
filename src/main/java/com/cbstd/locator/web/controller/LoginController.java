package com.cbstd.locator.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbstd.locator.entity.Permission;
import com.cbstd.locator.service.PermissionService;
import com.cbstd.locator.sys.service.I18nConfigService;

@Controller
@RequestMapping("/test")
public class LoginController {
	
	@Autowired
	PermissionService permissionService;

	@Autowired
	I18nConfigService i18nConfigService;
	
	@RequestMapping
	public String test(Model model) throws IllegalArgumentException, IllegalAccessException {
		
		Permission per = permissionService.findByCode("SP000001");
		
		//i18nConfigService.getRemark("loc_permission", "SP000001", Locale.US);
		
		//Permission per = permissionRepository.findByCode("SP000001");
		//String remark = per.getI18n("permissionRemark");
		
		model.addAttribute("message", "Hello World!"+"<br>Remark = " + per.getName());
		return "index";
	}

}
