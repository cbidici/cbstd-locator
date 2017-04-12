package com.cbstd.locator.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cbstd.locator.sys.entity.impl.ErrorMessageEntitiy;
import com.cbstd.locator.sys.exception.LocatorException;

/**
 * BaseApiController class should be extended by all api controllers.
 * This class takes care of exception handling for api
 * 2014-12-13
 * @author cbidici
 * @since 0.0.1
 */
public class BaseApiController {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = ValidationException.class)
	@ResponseBody
	public ErrorMessageEntitiy validationExHandler(HttpServletRequest req, Exception e) throws Exception
	{
		ErrorMessageEntitiy errorMessage = new ErrorMessageEntitiy();
		// TODO : Get localized message, Set default code etc.
		errorMessage.setException(e);
        return errorMessage;
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = LocatorException.class)
	@ResponseBody
	public ErrorMessageEntitiy locatorExHandler(HttpServletRequest req, LocatorException e) throws Exception
	{
		ErrorMessageEntitiy errorMessage = new ErrorMessageEntitiy();
		// TODO : Get localized message, Set code etc.
		errorMessage.setCode(e.getCode());
		errorMessage.setException(e);
        return errorMessage;
	}
	
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	@ExceptionHandler(value = AuthenticationException.class)
	@ResponseBody
	public ErrorMessageEntitiy accessExHandler(HttpServletRequest req, Exception e) throws Exception
	{
		ErrorMessageEntitiy errorMessage = new ErrorMessageEntitiy();
		// TODO : Get localized message, Set default code etc.
		//errorMessage.setException(e);
        return errorMessage;
	}
	
	

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ErrorMessageEntitiy exHandler(HttpServletRequest req, Exception e) throws Exception
	{
		ErrorMessageEntitiy errorMessage = new ErrorMessageEntitiy();
		// TODO : Get localized message, Set default code etc.
		errorMessage.setException(e);
        return errorMessage;
	}
}
