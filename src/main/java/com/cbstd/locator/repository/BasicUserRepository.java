package com.cbstd.locator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbstd.locator.entity.user.BasicUser;

/**
 * Repository for BasicUser
 * 2014-11-29
 * @author cbidici
 * @since 0.0.1
 */
public interface BasicUserRepository extends JpaRepository<BasicUser, Long> {

}
