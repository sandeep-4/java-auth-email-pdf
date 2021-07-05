package com.java.spring.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.reservation.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

}
