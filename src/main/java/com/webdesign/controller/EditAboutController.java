package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.AboutService;
import com.webdesign.service.S3Service;

@Controller
public class EditAboutController extends PermissionController {
	

	@Autowired
	private S3Service s3Service;

	@RequestMapping(value="/editAbout", method=RequestMethod.GET)
	public ModelAndView editAboutPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-about-page");
		/* add style, meta, navigation fragments */
		addFragments(model);		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editAboutContext", method=RequestMethod.GET)
	public ModelAndView editAboutContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-about/edit-context");
		
		model.addObject("imageList", s3Service.listAllFileUploads());

		/* add style, meta, navigation fragments */
		addFragments(model);
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@Autowired
	private AboutService aboutService;
		
	@RequestMapping(value="/newAboutContext", method=RequestMethod.POST)
	public ModelAndView newAboutContext(@RequestParam String url, @RequestParam String title,
			@RequestParam String description) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = aboutService.addNewContext(url, title, description);
		model.addObject("saved", saved);
		checkRole(model);
		/* add style, meta, navigation fragments */
		addFragments(model);
		return model;
	}
	
	@RequestMapping(value="/delete-about-context", method=RequestMethod.GET)
	public ModelAndView deleteAboutContext(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = aboutService.deleteContext(id);
		model.addObject("saved", saved);
		checkRole(model);
		/* add style, meta, navigation fragments */
		addFragments(model);
		return model;
	}
	
	@RequestMapping(value="/list-about-context", method=RequestMethod.GET)
	public ModelAndView listAboutContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-url-title-description");
		model.addObject("mainList", aboutService.listOfContext());
		checkRole(model);
		/* add style, meta, navigation fragments */
		addFragments(model);
		return model;
	}
}
