package com.cbstd.locator.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbstd.locator.entity.user.User;
import com.cbstd.locator.service.UserService;

@RestController
@RequestMapping("/api")
public class RegisterController extends BaseApiController{

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User register(@RequestBody @Valid User user) {
		
		return userService.saveUser(user);
	}

}
