package com.webdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditProjectsController extends PermissionController {

	@RequestMapping(value="/editProjects", method=RequestMethod.GET)
	public ModelAndView editProjectsPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-projects-page");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}

	@RequestMapping(value="/editProjetsContext", method=RequestMethod.GET)
	public ModelAndView editProjectsContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-projects/edit-context");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editProjectsList", method=RequestMethod.GET)
	public ModelAndView editProjectsList() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-projects/edit-projects");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
}
