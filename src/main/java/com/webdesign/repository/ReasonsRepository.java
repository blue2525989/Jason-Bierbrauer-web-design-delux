package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.Reason;

public interface ReasonsRepository extends JpaRepository<Reason, Long> {

	Reason findById(Long id);
	
	Reason findByName(String name);
}
