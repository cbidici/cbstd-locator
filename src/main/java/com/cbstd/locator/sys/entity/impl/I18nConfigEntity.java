/**
 * 
 */
package com.cbstd.locator.sys.entity.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity class for i18n configuration table.
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
@Entity
@Table(name="sys_i18n_config", uniqueConstraints={@UniqueConstraint(name="unq_sys_i18n_config_1", columnNames={"key", "table_name","column"})})
public class I18nConfigEntity extends BaseEntity {
	
	private static final long serialVersionUID = 1992376401359202678L;
	
	private String key;
	
	@Column(name="table_name")
	private String tableName;
	
	private String column;

	@ManyToOne
	@JoinColumn(name = "status_fk", foreignKey = @ForeignKey(name = "fk_sys_i18n_config_sys_dic_status_id"), nullable=false)
	private StatusEntity status;
	
	@OneToMany(mappedBy="i18nConfig")
	private List<I18nRemarkEntity> remarks;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public List<I18nRemarkEntity> getRemarks() {
		return remarks;
	}

	public void setRemarks(List<I18nRemarkEntity> remarks) {
		this.remarks = remarks;
	}
	
}
