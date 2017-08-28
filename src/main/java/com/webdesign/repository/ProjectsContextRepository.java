package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.ProjectsContext;

public interface ProjectsContextRepository extends JpaRepository<ProjectsContext, Long> {

	ProjectsContext findById(Long id);
	
	ProjectsContext findByName(String name);
}
