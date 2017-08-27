package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.HomeService;

@Controller
public class HomeController extends PermissionController {
 
   @Autowired
   private HomeService homeService;
 
   @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
   public ModelAndView welcomePage() {
	   ModelAndView model = new ModelAndView("index");
       model.addObject("mainList", homeService.reasonList());
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
}