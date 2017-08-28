package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.ContactContext;

public interface ContactContextRepository extends JpaRepository<ContactContext, Long> {

	ContactContext findById(Long id);
	
	ContactContext findByName(String name);
}
