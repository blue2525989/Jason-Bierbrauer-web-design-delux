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
		String saved;
		try {
			MetaFragment meta = new MetaFragment(title, iconUrl, metaDescription, metaKeywords);
			metaRepo.save(meta);
			saved = "The Meta Fragment has been saved.";
		} catch (Exception e) {
			saved = "You have entered an incorrect parameter.";
		}		
		return saved;
	}
	
	public String deleteMeta(Long id) {
		String saved = "";
		try {
			metaRepo.delete(id);
			saved = "The Meta Fragment has been deleted.";
		} catch (Exception e) {
			saved = "You have entered an incorrect parameter.";
		}		
		return saved;
	}
	
	public List<MetaFragment> listOfMetas() {
		return metaRepo.findAll();
	}
	
	public MetaFragment specificMeta() {
		try {
			List<MetaFragment> listFull = metaRepo.findAll();
			return listFull.get(listFull.size()-1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public String addNewStyle(String backgroundColor, String headerBackgroundColor, 
				String textColor, String mainContentBackgroundColor,
				String evenTableBackgroundColor, String oddTableBackgroundColor, String linkColor) {
		String saved = "";
		try {
			StyleSheetFragment style = new StyleSheetFragment(backgroundColor, headerBackgroundColor,
					textColor, mainContentBackgroundColor, evenTableBackgroundColor, oddTableBackgroundColor,
					linkColor);
			styleRepo.save(style);
			saved = "The Style Fragment has been saved.";
		} catch (Exception e) {
			saved = "You have entered an incorrect parameter.";
		}		
		return saved;
	}
	
	public String deleteStyle(Long id) {
		String saved = "";
		try {
			styleRepo.delete(id);
			saved = "The Style Fragment has been deleted.";
		} catch (Exception e) {
			saved = "You have entered an incorrect parameter.";
		}		
		return saved;
	}
	
	public List<StyleSheetFragment> listOfStyle() {
		return styleRepo.findAll();
	}
	
	public StyleSheetFragment specificStyle() {
		try {
			List<StyleSheetFragment> listFull = styleRepo.findAll();
			return listFull.get(listFull.size()-1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public String addNewNav(String homeButton, String servicesButton, String contactButton,
				String aboutButton, String projectsButton) {
		String saved = "";
		try {
			NavFragment nav = new NavFragment(homeButton, servicesButton, contactButton,
					aboutButton, projectsButton);
			navRepo.save(nav);
			saved = "The Nav Fragment has been saved.";
		} catch (Exception e) {
			saved = "You have entered an incorrect parameter.";
		}		
		return saved;
	}
	
	public String deleteNav(Long id) {
		String saved = "";
		try {
			navRepo.delete(id);
			saved = "The Nav Fragment has been deleted.";
		} catch (Exception e) {
			saved = "You have entered an incorrect parameter.";
		}		
		return saved;
	}
	
	public List<NavFragment> listOfNavs() {
		return navRepo.findAll();
	}
	
	public NavFragment specificNav() {
		try {
			List<NavFragment> listFull = navRepo.findAll();
			return listFull.get(listFull.size()-1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}	
	}
}
