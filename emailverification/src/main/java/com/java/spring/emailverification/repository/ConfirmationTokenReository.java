package com.java.spring.emailverification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.emailverification.model.ConfirmationToken;

@Repository
public interface ConfirmationTokenReository extends JpaRepository<ConfirmationToken, Long>{

	public ConfirmationToken findByConfirmationToken(String Confirmationtoken);
}
