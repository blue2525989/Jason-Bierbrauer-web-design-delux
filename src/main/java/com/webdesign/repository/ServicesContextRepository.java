package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.ServicesContext;

public interface ServicesContextRepository extends JpaRepository<ServicesContext, Long> {

	ServicesContext findById(Long id);
	
	ServicesContext findByName(String name);
}
