package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.Project;

public interface ProjectsRepository extends JpaRepository<Project, Long> {

	Project findById(Long id);
	
	Project findByName(String name);
}
