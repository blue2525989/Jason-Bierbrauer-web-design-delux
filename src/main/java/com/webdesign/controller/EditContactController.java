package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.EmailService;

@Controller
public class EditContactController extends PermissionController {

	@RequestMapping(value="editContact", method=RequestMethod.GET)
	public ModelAndView editContact() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-contact-page");
		/* add style, meta, navigation fragments */
		addFragments(model);
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editContactContext", method=RequestMethod.GET)
	public ModelAndView editContactContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-contact/edit-context");
		/* add style, meta, navigation fragments */
		addFragments(model);
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@Autowired
	private EmailService emailService;
	/* context */
	
	@RequestMapping(value="/newContactContext", method=RequestMethod.POST)
	public ModelAndView newContactContext(@RequestParam String title,
			@RequestParam String description) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = emailService.addNewContext(title, description);
		model.addObject("saved", saved);
		/* add style, meta, navigation fragments */
		addFragments(model);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-contact-context", method=RequestMethod.GET)
	public ModelAndView deleteContactContext(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = emailService.deleteContext(id);
		model.addObject("saved", saved);
		/* add style, meta, navigation fragments */
		addFragments(model);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-contact-context", method=RequestMethod.GET)
	public ModelAndView listContactContext() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-title-description");
		model.addObject("mainList", emailService.listOfContext());
		/* add style, meta, navigation fragments */
		addFragments(model);
		checkRole(model);
		return model;
	}
}
