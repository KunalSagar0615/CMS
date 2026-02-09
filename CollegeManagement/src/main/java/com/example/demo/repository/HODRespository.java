package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HOD;

@Repository
public interface HODRespository extends JpaRepository<HOD, Integer> {
	boolean findByEmail(String email);
	boolean findByMob(String mob);
}
