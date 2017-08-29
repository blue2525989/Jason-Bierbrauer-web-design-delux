package com.webdesign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webdesign.model.Services;
import com.webdesign.model.ServicesContext;
import com.webdesign.repository.ServicesContextRepository;
import com.webdesign.repository.ServicesRepository;

@Service
@Qualifier("servicesService")
public class ServicesService {
		
	@Autowired
	private ServicesRepository servicesRepo;
	
	public String addNewService(String title, String description) {
		Services service = new Services(title, description);
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
	
	public List<Services> listOfServices() {
		return servicesRepo.findAll();
	}
	
	/* adding page context, usually just a header and paragraph */
	
	@Autowired
	private ServicesContextRepository contextRepo;
	
	public String addNewContext(String title, String description) {
		ServicesContext context = new ServicesContext(title, description);
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
	public List<ServicesContext> listOfContext() {
		return contextRepo.findAll();
	}
	
	/* load context for page */
	public List<ServicesContext> loadSpecificContext() {
		List<ServicesContext> listFull = contextRepo.findAll();
		List<ServicesContext> list = new ArrayList<ServicesContext>();
		try {
			list.add(listFull.get(listFull.size()-1));
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		
		return list;
	}
}
