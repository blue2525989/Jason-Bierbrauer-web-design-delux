package com.webdesign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webdesign.model.SimpleContent;
import com.webdesign.repository.ProjectsContextRepository;
import com.webdesign.repository.ProjectsRepository;

@Service
@Qualifier("projectsService")
public class ProjectsService {
	
	SimpleContent ticking = new SimpleContent("http://tickingtoybomb.com/",
			"Ticking Toy Bomb",
			"Ticking Toy Bomb is an upcyclyed jewerly store web application. This website offers "
			+ "a Home page with links to the other pages, Drop down menu for the inventory, About page, "
			+ "Contact page using AWS SES custom email service, a Gallery and a Search bar with custom "
			+ "search algorithm."
			+ "<br/><br/>"
			+ "Every bit of content on this application is dynamic and stored in database tables. This allows "
			+ "the owner of the site to have full control over customizing Page content, Background color and Meta"
			+ "description/keywords, Page Title, Categories to choose in drop down menu, New Items to the inventory, "
			+ "Upload images to AWS S3 storage, Copy and paste PayPal button html from thier website to add custom "
			+ "PayPal buttons, and even more!"
			+ "<br/><br/>"
			+ "All of this is possible through leveraging the Spring Security framework along side Amazon's secruity "
			+ "to have the comfort of knowing your web application is safe!");
	
	SimpleContent wandering = new SimpleContent("http://wanderingwonderland.com/#/",
			"Wandering Wonderland",
			"Wandering Wonderland has a lighting fast interface thanks to using AngularJS. Visitors to your "
			+ "small business website will want to click through the pages quickly, otherwise you run the "
			+ "risk of loosing their business."
			+ "<br/><br/>"
			+ "Simple and elegant, this website is able to get the point of your business to your target "
			+ "audience quickly and effectively.");
	
	SimpleContent jbWebDesign = new SimpleContent("http://jasonbierbrauer.com/",
			"Jason Bierbrauer's Web Design",
			"Jason Bierbrauer's Web Design is the best of both worlds when it comes to a fast user interface "
			+ "and custom back end server capability."
			+ "<br/><br/>"
			+ "Thymeleaf is used to render the pages quickly and effectively. The Spring boot framework is "
			+ "also used to handle all the back end server requests. This application is small but built with "
			+ "scalibility in mind!"
			+ "<br/><br/>"
			+ "This application uses AWS's email service to send myself personalized emails that allow "
			+ "HTML tags for a cleaner format. This is useful to clean up the message and display it in a "
			+ "user freindly context. Also custom emails can be sent to your consumers with personalized formatting.");
	
	SimpleContent profile = new SimpleContent("https://blue2525989.github.io/Portfolio/#/portfolio/",
			"Project Portfolio",
			"This portfolio project is an example of a pure AngularJS website. These sort of SPA (single page applications) "
			+ "are designed for one simple purpose, a web footprint."
			+ "<br/><br/>"
			+ "If you are simply trying to put your businesses name out there and send people directions to you, "
			+ "this may be the web application for you. Add any pages you want with your custom content letting people "
			+ "know what it is you offer.");

	public List<SimpleContent> projectsList() {
		List<SimpleContent> projects = new ArrayList<SimpleContent>();
		projects.add(ticking);
		projects.add(wandering);
		projects.add(jbWebDesign);
		projects.add(profile);
		return projects;
	}
	
	@Autowired
	private ProjectsRepository projectRepo;
	
	public String addNewProject(String title, String description) {
		SimpleContent project = new SimpleContent(title, description);
		projectRepo.save(project);
		String saved = "The project, " + title + ", has been saved.";
		return saved;
	}
	
	public String deleteProject(Long id) {
		String title = projectRepo.findById(id).getName();
		projectRepo.delete(id);
		String saved = "The project, " + title + ", has been deleted.";
		return saved;
	}
	
	public List<SimpleContent> listOfProjects() {
		return projectRepo.findAll();
	}
	
	/* adding page context, usually just a header and paragraph */
	
	@Autowired
	private ProjectsContextRepository contextRepo;
	
	public String addNewContext(String title, String description) {
		SimpleContent context = new SimpleContent(title, description);
		contextRepo.save(context);
		String saved = "The new page context has been saved.";
		return saved;
	}
	
	public String deleteContext(Long id) {
		contextRepo.delete(id);
		String saved = "The page context has been deleted.";
		return saved;
	}
	
	/* for displaying entire list */
	public List<SimpleContent> listOfContext() {
		return contextRepo.findAll();
	}
	
	/* load context for page */
	public SimpleContent loadSpecificContext(Long id) {
		return contextRepo.findById(id);
	}
}
