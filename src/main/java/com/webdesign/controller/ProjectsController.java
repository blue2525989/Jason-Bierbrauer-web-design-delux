package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.ProjectsService;

@Controller
public class ProjectsController extends PermissionController {
	
	@Autowired
	private ProjectsService projectsService;
	
	@RequestMapping(value="/projects", method=RequestMethod.GET)
	public ModelAndView menu() {
		ModelAndView model = new ModelAndView();
		model.setViewName("pages/projects");
		model.addObject("mainList", projectsService.listOfProjects());
		model.addObject("contextList", projectsService.loadSpecificContext());
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
}
