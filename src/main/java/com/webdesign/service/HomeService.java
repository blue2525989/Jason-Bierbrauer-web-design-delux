package com.webdesign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdesign.model.HomeContext;
import com.webdesign.model.Reason;
import com.webdesign.repository.HomeContextRepository;
import com.webdesign.repository.ReasonsRepository;

@Service("homeService")
public class HomeService {

	@Autowired
	private ReasonsRepository reasonsRepo;
	
	public String addNewReason(String title, String description) {
		String saved = "";
		try {
			Reason reason = new Reason(title, description);
			reasonsRepo.save(reason);
			saved = "The new page context has been saved.";
		} catch (Exception e) {
			saved = "You have entered an incorrect parameter.";
		}		
		return saved;
	}
	
	public String deleteReason(Long id) {
		String saved = "";
		try {
			reasonsRepo.delete(id);
			saved = "The page context has been deleted.";
		} catch (Exception e) {
			saved = "You have entered an incorrect parameter.";
		}		
		return saved;
	}
	
	public List<Reason> listOfReasons() {
		return reasonsRepo.findAll();
	}

	/* adding page context, usually just a header and paragraph */
	
	@Autowired
	private HomeContextRepository contextRepo;
	
	public String addNewContext(String title, String description) {
		String saved = "";
		try {
			HomeContext context = new HomeContext(title, description);
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
	public List<HomeContext> listOfContext() {
		return contextRepo.findAll();
	}

	/* load context for page */
	public List<HomeContext> loadSpecificContext() {
		List<HomeContext> listFull = contextRepo.findAll();
		List<HomeContext> list = new ArrayList<HomeContext>();
		try {
			list.add(listFull.get(listFull.size()-1));
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		
		return list;
	}
}
