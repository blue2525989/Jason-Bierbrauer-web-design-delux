package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.EmailService;

@Controller
public class EmailController extends PermissionController {
	
	@Autowired
	private EmailService mailService;

	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public ModelAndView contactPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("pages/email");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/sendMail", method=RequestMethod.POST)
	public ModelAndView sendEmail(@RequestParam String name, @RequestParam String phone,
			@RequestParam String email, 
			@RequestParam String subject, @RequestParam String body) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		
		//create new email and send it
		String saved = mailService.sendMail(name, phone, email, subject, body);
		model.addObject("saved", saved);
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
}
