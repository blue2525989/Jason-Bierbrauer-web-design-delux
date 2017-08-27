package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.StyleSheetFragment;

public interface StyleFragmentRepository extends JpaRepository<StyleSheetFragment, Long> {

	StyleSheetFragment findById(Long id);
}
