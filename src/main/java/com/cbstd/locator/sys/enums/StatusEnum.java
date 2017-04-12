package com.cbstd.locator.sys.enums;

/**
 * Enum for statuses
 * 2014-11-30
 * @author cbidici
 * @since 0.0.1
 */
public enum StatusEnum {
	INIT(0),
	REINIT(1),
	MATCHED(2),
	STARTED(3),
	COMPLETED(4);
	
	private int value;
	
	private StatusEnum(int value)
	{
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
