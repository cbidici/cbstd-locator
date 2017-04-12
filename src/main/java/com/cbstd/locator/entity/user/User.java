package com.cbstd.locator.entity.user;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cbstd.locator.entity.Role;
import com.cbstd.locator.sys.entity.impl.BaseEntity;

/**
 * Main user entity. Keeps all user related information
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
@Entity
@Table(name = "loc_user", uniqueConstraints = { @UniqueConstraint(name = "unq_loc_user_user_id", columnNames = { "user_id" }) })
public class User extends BaseEntity {

	private static final long serialVersionUID = 4931773307917408014L;

	@Column(name="user_id")
	private String userId;
	
	@Column(name="create_date")
	private Timestamp createDate;
	
	@ManyToMany(mappedBy = "users")
	private List<Role> roles;
	
	@OneToOne(mappedBy = "user")
	private BasicUser basicUser;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public BasicUser getBasicUser() {
		return basicUser;
	}

	public void setBasicUser(BasicUser basicUser) {
		this.basicUser = basicUser;
	}
	
}
