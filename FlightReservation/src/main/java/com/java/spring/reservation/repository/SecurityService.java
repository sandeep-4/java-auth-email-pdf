package com.java.spring.reservation.repository;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
public boolean login(String username,String password);
}
