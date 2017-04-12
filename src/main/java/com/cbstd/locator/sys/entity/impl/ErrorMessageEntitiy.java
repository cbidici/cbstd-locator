package com.cbstd.locator.sys.entity.impl;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
/**
 * ErrorMessageEntity transfers exception information to related interfaces
 * 2014-12-13
 * @author cbidici
 * @since 0.0.1
 */
@Table(name = "sys_error_message", uniqueConstraints = { @UniqueConstraint(name = "unq_sys_error_message_1", columnNames = { "code" }) })
public class ErrorMessageEntitiy extends BaseEntity {

	private static final long serialVersionUID = -6223343269940167177L;

	private String code;
	
	private String message;
	
	private String description;
	
	private String advice;
	
	@Transient
	private Exception exception;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
}
