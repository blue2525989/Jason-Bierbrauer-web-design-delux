package com.webdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditAboutController extends PermissionController {

	@RequestMapping(value="/editAbout", method=RequestMethod.GET)
	public ModelAndView editAboutPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-about-page");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editAboutContext", method=RequestMethod.GET)
	public ModelAndView editAboutContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-about/edit-context");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
}
