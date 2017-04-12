package com.cbstd.locator.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cbstd.locator.entity.user.User;
import com.cbstd.locator.sys.entity.impl.BaseEntity;
import com.cbstd.locator.sys.entity.impl.StatusEntity;

/**
 * Role entity. Keeps relation between User and Permission
 * 2014-11-29 
 * @author cbidici
 * @since 0.0.1
 */
@Entity
@Table(name = "loc_role", uniqueConstraints = { @UniqueConstraint(name = "unq_loc_role_code", columnNames = { "code" }) })
public class Role extends BaseEntity {

	private static final long serialVersionUID = -2438414608061576156L;

	private String code;

	private String name;

	private String description;

	@ManyToOne
	@JoinColumn(name = "status_fk", foreignKey = @ForeignKey(name = "fk_role_sys_dic_status_id"), nullable = false)
	private StatusEntity status;

	@ManyToMany
	@JoinTable(name = "loc_perm_loc_role", joinColumns = @JoinColumn(name = "role_fk"), inverseJoinColumns = @JoinColumn(name = "permission_fk"), foreignKey = @ForeignKey(name = "fk_perm_role_role_id"), inverseForeignKey = @ForeignKey(name = "fk_perm_role_perm_id"))
	private List<Permission> permissions;
	
	@ManyToMany
	@JoinTable(name = "loc_user_loc_role", joinColumns = @JoinColumn(name = "role_fk"), inverseJoinColumns = @JoinColumn(name = "user_fk"), foreignKey = @ForeignKey(name = "fk_user_role_role_id"), inverseForeignKey = @ForeignKey(name = "fk_user_role_user_id"))
	private List<User> users;

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

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPersmissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
