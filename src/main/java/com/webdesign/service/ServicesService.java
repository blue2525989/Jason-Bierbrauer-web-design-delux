package com.webdesign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webdesign.model.SimpleContent;
import com.webdesign.repository.ServicesContextRepository;
import com.webdesign.repository.ServicesRepository;

@Service
@Qualifier("servicesService")
public class ServicesService {
	
	SimpleContent webDesign = new SimpleContent("Web Design", 
			"Let me create your footprint on the web. Having a website in todays economy can "
			+ "greatly drive your sales and presence. Let your customs know what your services are "
			+ "and why yours stand above your competitors. "
			+ "<br/><br/>"
			+ "Custom banners, photo galleries, custom email templates, and any other pages you would like "
			+ "can be added to help showcase your business!");
	
	SimpleContent websiteMaintenance = new SimpleContent("Web Maintenance",
			"Already have a custom website that needs a little touch up? Let me help you with that too!"
			+ "<br/><br/>"
			+ "Today most viewers will visit your website on thier mobile device. I use custom styling to ensure "
			+ "that all the pages show up as beautifully as you envisioned.");

	SimpleContent customBusinessSolutions = new SimpleContent("Custom Business Solutions",
			"Does your small business need an online solution to manage inventory, job progress, "
			+ "or connect your employees?"
			+ "<br/><br/>"
			+ "With building your small business solution on Amazon Web Service's platform not only do "
			+ "you have the comfort of security provided by Amazon but you also have access to the "
			+ "AWS tool suite and incorporting it into your business solution."
			+ "<br/><br/>"
			+ "This gives you the ability to set up email news letters, SMS messaging, file uploading, "
			+ "and so many more features.");
	
	public List<SimpleContent> serviceList() {
		List<SimpleContent> services = new ArrayList<SimpleContent>();
		services.add(webDesign);
		services.add(websiteMaintenance);
		services.add(customBusinessSolutions);
		return services;
	}
	
	@Autowired
	private ServicesRepository servicesRepo;
	
	public String addNewService(String title, String description) {
		SimpleContent service = new SimpleContent(title, description);
		servicesRepo.save(service);
		String saved = "The service, " + title + ", has been saved.";
		return saved;
	}
	
	public String deleteService(Long id) {
		String title = servicesRepo.findById(id).getName();
		servicesRepo.delete(id);
		String saved = "The service, " + title + ", has been deleted.";
		return saved;
	}
	
	public List<SimpleContent> listOfProjects() {
		return servicesRepo.findAll();
	}
	
	/* adding page context, usually just a header and paragraph */
	
	@Autowired
	private ServicesContextRepository contextRepo;
	
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
