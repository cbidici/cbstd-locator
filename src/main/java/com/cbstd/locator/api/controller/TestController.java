package com.cbstd.locator.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbstd.locator.api.TestDO;
import com.cbstd.locator.entity.user.User;
import com.cbstd.locator.service.UserService;

@RestController
@RequestMapping("/api")
public class TestController extends BaseApiController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/user/test")
	@Secured("LE_ADM")
	public TestDO test(@RequestParam(value="name", defaultValue="World") String name)
	{
		
		SecurityContextHolder.getContext();
		TestDO testDO = new TestDO();
		testDO.setMessage("Hello");
		testDO.setName(name);
		return testDO;
	}
	
	@RequestMapping("/login")
	public TestDO login()
	{
		TestDO testDO = new TestDO();
		testDO.setMessage("LOGIN");
		return testDO;
	}
	
	@RequestMapping("/user/{userId}")
	public User getUser(@PathVariable String userId)
	{
		return userService.loadByUserId(userId);
	}
	
	@RequestMapping(value = "/userecho", method = RequestMethod.POST)
	public User echoUser(@RequestBody User user)
	{
		return user;
	}
}
