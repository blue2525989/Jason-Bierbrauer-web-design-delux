package com.webdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController extends PermissionController {

	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/admin");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
}
