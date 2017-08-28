package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.webdesign.model.Services;

public interface ServicesRepository extends JpaRepository<Services, Long> {

	Services findById(Long id);
	
	Services findByName(String name);
}
