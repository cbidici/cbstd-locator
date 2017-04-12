package com.cbstd.locator.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cbstd.locator.sys.annotation.AddI18n;
import com.cbstd.locator.sys.entity.impl.BaseEntity;
import com.cbstd.locator.sys.entity.impl.StatusEntity;
import com.cbstd.locator.sys.entity.listener.I18nEntityListener;

/**
 * Permission entity to authorize user for operations
 * 2014-11-29 
 * @author cbidici
 * @since 0.0.1
 */
@Entity
@EntityListeners(I18nEntityListener.class)
@Table(name="loc_permission", uniqueConstraints = { @UniqueConstraint(name = "unq_loc_permission_code", columnNames = { "code" }) })
public class Permission extends BaseEntity {

	private static final long serialVersionUID = 5800197046379131446L;

	private String code;
	
	@AddI18n("code")
	private String name;
	
	@AddI18n("code")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "status_fk", foreignKey = @ForeignKey(name = "fk_permission_sys_dic_status_id"), nullable=false)
	private StatusEntity status;
	
	@ManyToMany(mappedBy = "permissions")
	private List<Role> roles;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
