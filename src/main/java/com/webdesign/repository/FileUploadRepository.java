package com.webdesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdesign.model.FileUpload;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {

	FileUpload findById(Long id);
}
