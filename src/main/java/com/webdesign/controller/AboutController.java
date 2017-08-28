package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.AboutService;


@Controller
public class AboutController extends PermissionController {
	
	@Autowired
	private AboutService aboutService;
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public ModelAndView menu() {
		ModelAndView model = new ModelAndView();
		model.setViewName("pages/about");
		model.addObject("context", aboutService.loadSpecificContext());
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
}
