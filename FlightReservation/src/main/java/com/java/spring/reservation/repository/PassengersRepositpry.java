package com.java.spring.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.reservation.model.Passanger;


public interface PassengersRepositpry extends JpaRepository<Passanger,Integer>{

}
