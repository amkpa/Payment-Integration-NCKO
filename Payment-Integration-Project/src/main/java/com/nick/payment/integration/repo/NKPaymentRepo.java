package com.nick.payment.integration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nick.payment.integration.entity.NKPayment;

public interface NKPaymentRepo extends JpaRepository<NKPayment, Long> {
	@Query("SELECT p FROM NKPayment p LEFT JOIN FETCH p.nkUser")
	List<NKPayment> findAllWithUser();
}
