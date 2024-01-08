package com.nick.payment.integration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nick.payment.integration.entity.NKUser;

@Repository
public interface NKUserRepo extends JpaRepository<NKUser, Long> {
	NKUser findByNkUsername(String username);
	boolean existsByNkUsername(String username);
}
