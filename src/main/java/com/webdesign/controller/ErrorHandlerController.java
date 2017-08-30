package com.webdesign.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ErrorHandlerController extends PermissionController implements ErrorController{
		
	/* return as String instead of ModelAndView */
	@RequestMapping(value="/error", method=RequestMethod.GET)
	public ModelAndView error() {		
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		/* add style, meta, navigation fragments */
		addFragments(model);
		checkRole(model);
		return model;
	}
	
	/* return as String instead of ModelAndView */
	@RequestMapping(value="/error", method=RequestMethod.POST)
	public ModelAndView error(String error) {		
		ModelAndView model = new ModelAndView();
		model.setViewName("error");
		/* add error String */
		model.addObject("error", error);
		/* add style, meta, navigation fragments */
		addFragments(model);
		checkRole(model);
		return model;
	}
	
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
