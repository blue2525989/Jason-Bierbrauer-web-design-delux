package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.S3Service;

@Controller
public class UploadS3Controller extends PermissionController {

	@Autowired
	private S3Service s3Service;
	
	@RequestMapping(value="/uploadS3", method=RequestMethod.GET)
	public ModelAndView uploadS3() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/upload-s3");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/upload-s3", method=RequestMethod.GET)
	public ModelAndView uploadFileToS3Page() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/upload/upload-file");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/uploadFileS3", method=RequestMethod.POST)
	public ModelAndView uploadFileToS3(@RequestParam String title, @RequestParam String description,
			@RequestParam MultipartFile file, MultipartRequest event) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = s3Service.upload(file, event, title, description);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-image", method=RequestMethod.GET)
	public ModelAndView deleteImage(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = s3Service.deleteFile(id);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-images", method=RequestMethod.GET)
	public ModelAndView listFiles() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/upload/list-files");
		model.addObject("mainList", s3Service.listAllFileUploads());
		checkRole(model);
		return model;
	}
}
