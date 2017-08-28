package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditSiteFormatController extends PermissionController {

	@RequestMapping(value="/editSiteFormat", method=RequestMethod.GET)
	public ModelAndView editServices() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-site-format");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editMeta", method=RequestMethod.GET)
	public ModelAndView editMetaData() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-site-format/edit-meta");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editNav", method=RequestMethod.GET)
	public ModelAndView editNav() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-site-format/edit-nav");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editStyle", method=RequestMethod.GET)
	public ModelAndView editStyle() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-site-format/edit-style");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	/* database controllers */
	
	//@Autowired
	/* need to create services for meta, style, and nav */
	
	/* repeat these controllers two more times for meta and nav */
	
	
	@RequestMapping(value="/newStyle", method=RequestMethod.POST)
	public ModelAndView newStyle(@RequestParam String title, @RequestParam String description,
			@RequestParam MultipartFile file, MultipartRequest event) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = "replace with service.";
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-style", method=RequestMethod.GET)
	public ModelAndView deleteStyle(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = "replace with service";
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-styles", method=RequestMethod.GET)
	public ModelAndView listStyles() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-files");
		model.addObject("mainList", "replace with service");
		checkRole(model);
		return model;
	}
}
