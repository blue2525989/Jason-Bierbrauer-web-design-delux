package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.HomeContext;

public interface HomeContextRepository extends JpaRepository<HomeContext, Long> {

	HomeContext findById(Long id);
	
	HomeContext findByName(String name);
}
