package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.NavFragment;

public interface NavFragmentRepository extends JpaRepository<NavFragment, Long> {

	NavFragment findById(Long id);
}
