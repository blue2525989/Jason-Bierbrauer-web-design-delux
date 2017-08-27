package com.webdesign.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

public class PermissionController {
	
	// autowire the repository to the controller
		
	/**
	 * This method checks the users authentication level
	 * @return true or false
	 */
	
	public boolean hasUserRole() {
		// this checks to see if a user has a user role
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
		         .anyMatch(r -> r.getAuthority().equals("ROLE_USER"));
		return hasUserRole;
	}
	
	/**
	 * This method returns the users authentication level
	 * @return true or false
	 * 
	 */
	
	public boolean hasAdminRole() {
		// this checks to see if a user has a admin role.
		Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
		boolean hasAdminRole = authentication2.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
		return hasAdminRole;
	}
	
	public void checkRole(ModelAndView model) {
		// admin user
		if (hasAdminRole()) {
			model.addObject("adminrole", hasAdminRole());
		}
		// regular user
		else if (hasUserRole()) {
			model.addObject("userrole", hasUserRole());
		}
		else {
			model.addObject("norole");
		}
	}

}
