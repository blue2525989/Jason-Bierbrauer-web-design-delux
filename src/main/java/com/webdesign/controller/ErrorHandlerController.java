package com.webdesign.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ErrorHandlerController extends PermissionController implements ErrorController{
		
	/* return as String instead of ModelAndView */
	@RequestMapping(value="/error", method=RequestMethod.GET)
	public String error(Model model) {
		
		/* sets either user_role or admin_role */
		if (hasAdminRole()) {
			model.addAttribute("adminrole", hasAdminRole());
		}
		// regular user
		else if (hasUserRole()) {
			model.addAttribute("userrole", hasUserRole());
		}
		else {
			model.addAttribute("norole");
		}
		return "error";
	}
	
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
