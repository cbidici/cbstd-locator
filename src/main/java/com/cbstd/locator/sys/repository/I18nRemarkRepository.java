package com.cbstd.locator.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbstd.locator.sys.entity.impl.I18nRemarkEntity;

/**
 * Repository interface for i18n remark
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public interface I18nRemarkRepository extends JpaRepository<I18nRemarkEntity, Long> {

}
