package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.SimpleContent;

public interface ServicesRepository extends JpaRepository<SimpleContent, Long> {

	SimpleContent findById(Long id);
	
	SimpleContent findByName(String name);
}
