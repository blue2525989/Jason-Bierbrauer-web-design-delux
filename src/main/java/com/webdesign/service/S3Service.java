package com.webdesign.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.webdesign.model.FileUpload;
import com.webdesign.repository.FileUploadRepository;


@Service
@Qualifier("s3Service")
public class S3Service {

	@Autowired
	private AmazonS3Client s3client;
	
	@Autowired
	private FileUploadRepository fileUploadRepo;
	
	private final String S3URL = "";
	
	private final String FOLDERNAME = "";
	
	/**
	 *  upload file to amazon s3 
	 * @param file to upload
	 * @param event fetches the file
	 * @param title give the file a fancy title
	 * @param description give the file a fancy description
	 * @return message describing success or faliure
	 */
	
	public String upload(MultipartFile file, MultipartRequest event, 
			String title, String description) {
		/*
		 * Obtain the Content length of the Input stream for S3 header
		 */
		
		byte[] contentBytes = null;
		try {
		    InputStream is = event.getFile(file.getName()).getInputStream();
		    contentBytes = IOUtils.toByteArray(is);
		} catch (IOException e) {
		    return "Failed while reading bytes from " + e.getMessage();
		} 

		Long contentLength = Long.valueOf(contentBytes.length);

		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(contentLength);
		metadata.setContentType(file.getContentType());		

		/*
		 * Reobtain the tmp uploaded file as input stream
		 */
		
		InputStream inputStream = null;
		try {
			inputStream = event.getFile(file.getName()).getInputStream();
		} catch (IOException e) {
			return e.getMessage();
		}

		/*
		 * Put the object in S3
		 */
		
		try {

		    s3client.putObject(new PutObjectRequest(FOLDERNAME ,
		    		file.getOriginalFilename(), inputStream, metadata).withCannedAcl(CannedAccessControlList.PublicReadWrite));

		} catch (AmazonServiceException ase) {
			String errorMsg = 
				  "Error Message:    " + ase.getMessage()
				+ "HTTP Status Code: " + ase.getStatusCode()
				+ "AWS Error Code:   " + ase.getErrorCode()
				+ "Error Type:       " + ase.getErrorType()
				+ "Request ID:       " + ase.getRequestId();
			return errorMsg;
		} catch (AmazonClientException ace) {
		    return ace.getMessage();
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					return e.getMessage();
				}
		    }
		}
		
		FileUpload img = new FileUpload();
		img.setTitle(file.getOriginalFilename());
		img.setUrl(S3URL + FOLDERNAME + "/" +file.getOriginalFilename());
		img.setDescription(description);
		img.setFilename(file.getOriginalFilename());
		// SAVE TO A REPOSITORY
		fileUploadRepo.save(img);
		
		String saved = "The file, " + file.getOriginalFilename() + " has been saved to the folder, " 
				+ FOLDERNAME + ". The link for the new file is, <a target='_blank' href='" 
				+ img.getUrl() + "' alt='" + file.getOriginalFilename() + "'"
						+ " title='" + file.getOriginalFilename() + "'>" + file.getOriginalFilename() + "</a>";
		
		return saved;
	}
	
	/**
	 * 
	 * @param id of file to delete
	 * @return message
	 */
	
	public String deleteFile(Long id) {
		String fileName = fileUploadRepo.findById(id).getFilename();
		fileUploadRepo.delete(id);
		try {
			s3client.deleteObject(new DeleteObjectRequest(FOLDERNAME, fileName));
		} catch (AmazonServiceException ase) {
			String errorMsg = 
				  "Error Message:    " + ase.getMessage()
				+ "HTTP Status Code: " + ase.getStatusCode()
				+ "AWS Error Code:   " + ase.getErrorCode()
				+ "Error Type:       " + ase.getErrorType()
				+ "Request ID:       " + ase.getRequestId();
			return errorMsg;
		} catch (AmazonClientException ace) {
			return ace.getMessage();
		}
		String saved = "The file, " + fileName + ", has been deleted from the repository and S3 storage.";
		return saved;
	}
	
	/**
	 *  list all file uploads
	 * @return FileUpload list
	 */
	
	public List<FileUpload> listAllFileUploads() {
		return fileUploadRepo.findAll();
	}
}
