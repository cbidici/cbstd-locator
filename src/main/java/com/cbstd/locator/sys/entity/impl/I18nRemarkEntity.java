package com.cbstd.locator.sys.entity.impl;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity class for i18n remark table.
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
@Entity
@Table(name="sys_i18n_remark", uniqueConstraints={@UniqueConstraint(name="unq_sys_i18n_remark_1", columnNames={"i18n_config_fk","locale"})})
public class I18nRemarkEntity extends BaseEntity {

	private static final long serialVersionUID = 635917040160307353L;
	
	private Locale locale;
	
	private String remark;
	
	@ManyToOne
	@JoinColumn(name = "status_fk", foreignKey = @ForeignKey(name = "fk_sys_i18n_remark_sys_dic_status_id"), nullable=false)
	private StatusEntity status;
	
	@ManyToOne
	@JoinColumn(name = "i18n_config_fk", foreignKey = @ForeignKey(name = "fk_sys_i18n_remark_sys_i18n_config_id"), nullable = false)
	private I18nConfigEntity i18nConfig;
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getRemark() {
		return remark;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public I18nConfigEntity getI18nConfig() {
		return i18nConfig;
	}

	public void setI18nConfig(I18nConfigEntity i18nConfig) {
		this.i18nConfig = i18nConfig;
	}
	
	@Override
	public String toString()
	{
		return this.remark;
	}
	
}
