package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.MetaFragment;

public interface MetaFragmentRepository extends JpaRepository<MetaFragment, Long> {

	MetaFragment findById(Long id);
}
