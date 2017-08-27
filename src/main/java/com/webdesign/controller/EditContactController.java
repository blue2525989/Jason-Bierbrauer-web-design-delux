package com.webdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditContactController extends PermissionController {

	@RequestMapping(value="editContact", method=RequestMethod.GET)
	public ModelAndView editContact() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-contact-page");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editContactContext", method=RequestMethod.GET)
	public ModelAndView editContactContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-contact/edit-context");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
}
