package com.webdesign.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ErrorHandlerController extends PermissionController implements ErrorController{
		
	@RequestMapping(value="/error", method=RequestMethod.GET)
	public ModelAndView error() {
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
