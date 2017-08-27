package com.webdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
