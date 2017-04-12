package com.cbstd.locator.entity.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.cbstd.locator.sys.entity.impl.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * BasicUser information. The user information entity for users who registered to application with email.
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
@Entity
@Table(name = "loc_basic_user", uniqueConstraints = {
		@UniqueConstraint(name = "unq_loc_basic_user_username", columnNames = { "username" }),
		@UniqueConstraint(name = "unq_loc_basic_user_email", columnNames = { "email" }) })
public class BasicUser extends BaseEntity {

	private static final long serialVersionUID = -188280086339343854L;

	@NotNull
	private String username;

	@NotNull
	private String email;

	@NotNull
	private String password;

	private Boolean verified;
	
	@Column(name = "create_date")
	private Timestamp createDate;
	
	@OneToOne
	@JoinColumn(name = "user_fk", foreignKey = @ForeignKey(name = "fk_loc_basic_user_loc_user_id"), nullable = false)
	@JsonIgnore
	private User user;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
