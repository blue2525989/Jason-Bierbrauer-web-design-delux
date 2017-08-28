package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.AboutContext;

public interface AboutContextRepository extends JpaRepository<AboutContext, Long> {

	AboutContext findById(Long id);
	
	AboutContext findByName(String name);
}
