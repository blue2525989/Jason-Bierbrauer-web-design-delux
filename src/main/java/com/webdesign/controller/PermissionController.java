package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.SiteFormatService;

public class PermissionController {
	
	// autowire the repository to the controller
	@Autowired
	private SiteFormatService siteFormatService;
	
	public void addFragments(ModelAndView model) {
		addNavFrag(model);
		addStyle(model);
		addMeta(model);
	}
	
	public void addNavFrag(ModelAndView model) {
		if (siteFormatService.specificNav() != null) {
			model.addObject("navFrag", siteFormatService.specificNav());
		}
	}
	
	public void addStyle(ModelAndView model) {
		if (siteFormatService.specificStyle() != null) {
			model.addObject("styleFrag", siteFormatService.specificStyle());
		}
	}
	
	public void addMeta(ModelAndView model) {
		if (siteFormatService.specificMeta() != null) {
			model.addObject("metaFrag", siteFormatService.specificMeta());
		}
	}
		
	/**
	 * This method checks the users authentication level
	 * @return true or false
	 */
	
	public boolean hasUserRole() {
		// this checks to see if a user has a user role
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
		         .anyMatch(r -> r.getAuthority().equals("ROLE_USER"));
		if (hasUserRole) {
			return hasUserRole;
		} else {
			return false;
		}
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
		if (hasAdminRole) {
			return hasAdminRole;
		} else {
			return false;
		}
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
