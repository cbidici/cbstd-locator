package com.cbstd.locator.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbstd.locator.sys.entity.impl.StatusEntity;
import com.cbstd.locator.sys.enums.StatusEnum;

/**
 * Repository for status
 * 2014-11-30
 * @author cbidici
 * @since 0.0.1
 */
public interface StatusRepository extends JpaRepository<StatusEntity, StatusEnum> {

}
