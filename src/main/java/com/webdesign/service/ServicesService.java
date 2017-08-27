package com.webdesign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webdesign.model.SimpleContent;

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
}
