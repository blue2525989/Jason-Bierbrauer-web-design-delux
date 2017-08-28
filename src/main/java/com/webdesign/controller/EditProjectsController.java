package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.ProjectsService;

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
	
	@Autowired
	private ProjectsService projectsService;
	
	/* context */
	
	@RequestMapping(value="/newProjectsContext", method=RequestMethod.POST)
	public ModelAndView newProjectsContext(@RequestParam String title,
			@RequestParam String description) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = projectsService.addNewContext(title, description);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-projects-context", method=RequestMethod.GET)
	public ModelAndView deleteProjectsContext(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = projectsService.deleteContext(id);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-projects-context", method=RequestMethod.GET)
	public ModelAndView listProjectsContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-title-description");
		model.addObject("mainList", projectsService.listOfContext());
		checkRole(model);
		return model;
	}
	
	/* services */
	
	@RequestMapping(value="/newProjects", method=RequestMethod.POST)
	public ModelAndView newProjects(@RequestParam String title,
			@RequestParam String url, @RequestParam String description) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = projectsService.addNewProject(url, title, description);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-projects", method=RequestMethod.GET)
	public ModelAndView deleteServices(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = projectsService.deleteProject(id);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-projects", method=RequestMethod.GET)
	public ModelAndView listAboutContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-title-description");
		model.addObject("mainList", projectsService.listOfProjects());
		checkRole(model);
		return model;
	}
}
