package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.HomeService;

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
	
	@Autowired
	private HomeService homeService;
	
	/* context */
	
	@RequestMapping(value="/newHomeContext", method=RequestMethod.POST)
	public ModelAndView newHomeContext(@RequestParam String title,
			@RequestParam String description) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = homeService.addNewContext(title, description);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-home-context", method=RequestMethod.GET)
	public ModelAndView deleteHomeContext(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = homeService.deleteContext(id);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-home-context", method=RequestMethod.GET)
	public ModelAndView listHomeContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-title-description");
		model.addObject("mainList", homeService.listOfContext());
		checkRole(model);
		return model;
	}
	
	/* services */
	
	@RequestMapping(value="/newReasons", method=RequestMethod.POST)
	public ModelAndView newReason(@RequestParam String title,
			@RequestParam String description) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = homeService.addNewReason(title, description);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-reasons", method=RequestMethod.GET)
	public ModelAndView deleteReasons(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = homeService.deleteReason(id);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-reasons", method=RequestMethod.GET)
	public ModelAndView listReasons() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-title-description");
		model.addObject("mainList", homeService.listOfReasons());
		checkRole(model);
		return model;
	}
}
