package com.cbstd.locator.sys.exception;

/**
 * Application specific exception
 * 2014-12-13
 * @author cbidici
 * @since 0.0.1
 */
public class LocatorException extends Exception {

	private static final long serialVersionUID = 2726292014080738018L;

	private String code;

	public LocatorException(String code) {
		super();
		setCode(code);
	}

	public LocatorException(String code, String message) {
		super(message);
		setCode(code);
	}

	public LocatorException(String code, Throwable cause) {
		super(cause);
		setCode(code);
	}

	public LocatorException(String code, String message, Throwable cause) {
		super(message, cause);
		setCode(code);
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
