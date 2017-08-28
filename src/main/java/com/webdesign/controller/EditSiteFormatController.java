package com.webdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webdesign.service.SiteFormatService;

@Controller
public class EditSiteFormatController extends PermissionController {

	@RequestMapping(value="/editSiteFormat", method=RequestMethod.GET)
	public ModelAndView editServices() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-site-format");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editMeta", method=RequestMethod.GET)
	public ModelAndView editMetaData() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-site-format/edit-meta");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editNav", method=RequestMethod.GET)
	public ModelAndView editNav() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-site-format/edit-nav");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/editStyle", method=RequestMethod.GET)
	public ModelAndView editStyle() {
		ModelAndView model = new ModelAndView();
		model.setViewName("edit/edit-site-format/edit-style");
		
		/* sets either user_role or admin_role */
		checkRole(model);
		return model;
	}
	
	/* database controllers */
	
	@Autowired
	private SiteFormatService siteFormatService;
	
	/* repeat these controllers two more times for meta and nav */
	
	
	@RequestMapping(value="/newStyle", method=RequestMethod.POST)
	public ModelAndView newStyle(@RequestParam String backgroundColor, @RequestParam String headerBackgroundColor,
			@RequestParam String textColor, @RequestParam String mainContentBackgroundColor, @RequestParam String evenTableBackgroundColor,
			@RequestParam String oddTableBackgroundColor, @RequestParam String linkColor) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = siteFormatService.addNewStyle(backgroundColor, headerBackgroundColor, textColor,
				mainContentBackgroundColor, evenTableBackgroundColor, oddTableBackgroundColor, linkColor);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-style", method=RequestMethod.GET)
	public ModelAndView deleteStyle(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = siteFormatService.deleteStyle(id);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-styles", method=RequestMethod.GET)
	public ModelAndView listStyles() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-style");
		model.addObject("mainList", siteFormatService.listOfStyle());
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/newMeta", method=RequestMethod.POST)
	public ModelAndView newMeta(@RequestParam String title, @RequestParam String iconUrl,
			@RequestParam String metaDescription, @RequestParam String metaKeywords) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = siteFormatService.addNewMeta(title, iconUrl, metaDescription, metaKeywords);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-meta", method=RequestMethod.GET)
	public ModelAndView deleteMeta(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = siteFormatService.deleteMeta(id);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-metas", method=RequestMethod.GET)
	public ModelAndView listMetas() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-meta");
		model.addObject("mainList", siteFormatService.listOfMetas());
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/newNav", method=RequestMethod.POST)
	public ModelAndView newNav(@RequestParam String homeButton, @RequestParam String servicesButton,
			@RequestParam String contactButton, @RequestParam String aboutButton, @RequestParam String projectsButton,
			@RequestParam String oddTableBackgroundColor, @RequestParam String linkColor) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = siteFormatService.addNewNav(homeButton, servicesButton, contactButton, aboutButton, projectsButton);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/delete-nav", method=RequestMethod.GET)
	public ModelAndView deleteNav(@RequestParam Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin-pages/saved");
		String saved = siteFormatService.deleteNav(id);
		model.addObject("saved", saved);
		checkRole(model);
		return model;
	}
	
	@RequestMapping(value="/list-navs", method=RequestMethod.GET)
	public ModelAndView listNavs() {
		ModelAndView model = new ModelAndView();
		model.setViewName("list/list-nav");
		model.addObject("mainList", siteFormatService.listOfNavs());
		checkRole(model);
		return model;
	}
}
