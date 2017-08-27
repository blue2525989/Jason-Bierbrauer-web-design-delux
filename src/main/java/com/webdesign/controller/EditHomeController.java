package com.webdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditHomeController extends PermissionController {

	@RequestMapping(value="editHome", method=RequestMethod.GET)
	public ModelAndView editHome() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-home-page");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editHomeContext", method=RequestMethod.GET)
	public ModelAndView editHomeContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-home-page/edit-context");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editReasons", method=RequestMethod.GET)
	public ModelAndView editReasons() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-home-page/edit-reasons");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
}
