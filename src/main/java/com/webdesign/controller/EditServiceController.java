package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.ServicesService;

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
	
	@Autowired
	private ServicesService servicesService;
	
	/* context */
	
	@RequestMapping(value="/newServicesContext", method=RequestMethod.POST)
	public ModelAndView newServicesContext(@RequestParam String title,
			@RequestParam String description) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = servicesService.addNewContext(title, description);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-services-context", method=RequestMethod.GET)
	public ModelAndView deleteServicesContext(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = servicesService.deleteContext(id);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-services-context", method=RequestMethod.GET)
	public ModelAndView listServicesContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-title-description");
		model.addObject("mainList", servicesService.listOfContext());
		checkRole(model);
		return model;
	}
	
	/* services */
	
	@RequestMapping(value="/newServices", method=RequestMethod.POST)
	public ModelAndView newAboutContext(@RequestParam String title,
			@RequestParam String description) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = servicesService.addNewService(title, description);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-services", method=RequestMethod.GET)
	public ModelAndView deleteServices(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = servicesService.deleteService(id);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-services", method=RequestMethod.GET)
	public ModelAndView listAboutContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-title-description");
		model.addObject("mainList", servicesService.listOfServices());
		checkRole(model);
		return model;
	}
}
