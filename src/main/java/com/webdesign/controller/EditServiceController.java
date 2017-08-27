package com.webdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditServiceController extends PermissionController {

	@RequestMapping(value="/editServices", method=RequestMethod.GET)
	public ModelAndView editServicesPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-services-page");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editServicesContext", method=RequestMethod.GET)
	public ModelAndView editServicesContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-services/edit-context");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editServicesOffered", method=RequestMethod.GET)
	public ModelAndView editServicesList() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-services/edit-services");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
}
