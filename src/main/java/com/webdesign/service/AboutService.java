package com.webdesign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webdesign.model.AboutContext;
import com.webdesign.repository.AboutContextRepository;

@Service
@Qualifier("aboutService")
public class AboutService {

	@Autowired
	private AboutContextRepository contextRepo;
	
	public String addNewContext(String url, String title, String description) {
		String saved = "";
		try {
			AboutContext context = new AboutContext(url, title, description);
			contextRepo.save(context);
			saved = "The new page context has been saved.";
		} catch (Exception e) {
			saved = "You have entered an incorrect parameter.";
		}		
		return saved;
	}
	
	public String deleteContext(Long id) {
		String saved = "";
		try {
			contextRepo.delete(id);
			saved = "The page context has been deleted.";
		} catch (Exception e) {
			saved = "You have entered an incorrect parameter.";
		}		
		return saved;
	}
	
	/* for displaying entire list */
	public List<AboutContext> listOfContext() {
		return contextRepo.findAll();
	}
	
	/* load context for page */
	public List<AboutContext> loadSpecificContext() {
		List<AboutContext> listFull = contextRepo.findAll();
		List<AboutContext> list = new ArrayList<AboutContext>();
		try {
			list.add(listFull.get(listFull.size()-1));
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		
		return list;
	}
}
