package com.cbstd.locator.sys.entity.impl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cbstd.locator.sys.annotation.AddI18n;
import com.cbstd.locator.sys.enums.StatusEnum;

/**
 * Status class to keep basic statuses like ACTIVE, DEACTIVE and DELETED
 * 2014-11-30
 * @see StatusEnum
 * @author cbidici
 * @since 0.0.1
 */
@Entity
@Table(name = "sys_dic_status")
public class StatusEntity implements Serializable {

	private static final long serialVersionUID = 5996601372456564052L;

	@Id
	@Enumerated(EnumType.ORDINAL)
	private StatusEnum id;
	
	@AddI18n("id")
	private String name;
	
	@AddI18n("id")
	private String description;

	public StatusEnum getId() {
		return id;
	}

	public void setId(StatusEnum id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
