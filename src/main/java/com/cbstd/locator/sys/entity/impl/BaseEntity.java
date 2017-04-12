package com.cbstd.locator.sys.entity.impl;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Base class to be extended by all entity classes
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1677356626399931581L;
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
