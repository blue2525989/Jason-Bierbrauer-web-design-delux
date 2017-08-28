package com.webdesign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webdesign.model.MetaFragment;
import com.webdesign.model.NavFragment;
import com.webdesign.model.StyleSheetFragment;
import com.webdesign.repository.MetaFragmentRepository;
import com.webdesign.repository.NavFragmentRepository;
import com.webdesign.repository.StyleFragmentRepository;

@Service
@Qualifier("siteFormatService")
public class SiteFormatService {
	
		
	@Autowired
	private MetaFragmentRepository metaRepo;
	@Autowired
	private StyleFragmentRepository styleRepo;
	@Autowired
	private NavFragmentRepository navRepo;
	
	public String addNewMeta(String title, String iconUrl,
			String metaDescription, String metaKeywords) {
		MetaFragment meta = new MetaFragment(title, iconUrl, metaDescription, metaKeywords);
		metaRepo.save(meta);
		String saved = "The Meta Fragment has been saved.";
		return saved;
	}
	
	public String deleteMeta(Long id) {
		metaRepo.delete(id);
		String saved = "The Meta Fragment has been deleted.";
		return saved;
	}
	
	public List<MetaFragment> listOfMetas() {
		return metaRepo.findAll();
	}

	public String addNewStyle(String backgroundColor, String headerBackgroundColor, 
				String textColor, String mainContentBackgroundColor,
				String evenTableBackgroundColor, String oddTableBackgroundColor, String linkColor) {
		StyleSheetFragment style = new StyleSheetFragment(backgroundColor, headerBackgroundColor,
				textColor, mainContentBackgroundColor, evenTableBackgroundColor, oddTableBackgroundColor,
				linkColor);
		styleRepo.save(style);
		String saved = "The Style Fragment has been saved.";
		return saved;
	}
	
	public String deleteStyle(Long id) {
		styleRepo.delete(id);
		String saved = "The Style Fragment has been deleted.";
		return saved;
	}
	
	public List<StyleSheetFragment> listOfStyle() {
		return styleRepo.findAll();
	}
	
	public String addNewNav(String homeButton, String servicesButton, String contactButton,
				String aboutButton, String projectsButton) {
		NavFragment nav = new NavFragment(homeButton, servicesButton, contactButton,
				aboutButton, projectsButton);
		navRepo.save(nav);
		String saved = "The Nav Fragment has been saved.";
		return saved;
	}
	
	public String deleteNav(Long id) {
		navRepo.delete(id);
		String saved = "The Nav Fragment has been deleted.";
		return saved;
	}
	
	public List<NavFragment> listOfNavs() {
		return navRepo.findAll();
	}
	

}
