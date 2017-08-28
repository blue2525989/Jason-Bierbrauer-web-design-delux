package com.webdesign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdesign.model.HomeContext;
import com.webdesign.model.Reason;
import com.webdesign.model.SimpleContent;
import com.webdesign.repository.HomeContextRepository;
import com.webdesign.repository.ReasonsRepository;

@Service("homeService")
public class HomeService {
	
	public SimpleContent credibility = new SimpleContent("Credibility", 
			"Today, more and more consumers use the internet to search for the "
			+ "products or services they need. Your small business will gain "
			+ "credibility by having a website. Without one, potential customers "
			+ "will go to your competitors that do. "
			+ "<br/><br/>"
			+ "If you already have a website "
			+ "but it is \"home-made\", having it professionally redesigned will "
			+ "provide your business with a professional image which will inspire "
			+ "even greater confidence. For home-based businesses, this is particularly "
			+ "beneficial since you do not have a store front to promote your products or services.");
	
	public SimpleContent saveMoney = new SimpleContent("Saves you Money!", 
			"As a small business owner you probably think you can't afford a professional "
			+ "website, but you can't afford NOT to. "
			+ "<br/><br/>"
			+ "Although the cost of designing a website "
			+ "varies, once it's up and running, a website for a small business generally costs "
			+ "under $100 a month and, in some cases, as little as $20. Compared with the cost "
			+ "of a newspaper ad, when you consider the potential market you can reach with a "
			+ "website, it is a very cost effective way to promote your business.");
	
	public SimpleContent alwaysOpen = new SimpleContent("Always Accesible",
			"A website is available to both your regular and potential customers 24/7/365 "
			+ "providing them with the convenience of reviewing your products and services "
			+ "when your store or office is closed. With today’s busy lifestyles, this is a great"
			+ " selling point when making a purchase decision.");
	
	public SimpleContent wideAudience = new SimpleContent("Wider Market",
			"Whether you provide products or services, your website will provide an alternative location "
			+ "to sell them. As a retailer, a website (eCommerce) is a great place to sell your products "
			+ "to a wider market; even services can be made available globally. Don't think you'll be "
			+ "able to sell your products or services online? Don't forget, even cars and houses sell online!");
	
	public SimpleContent saveTime = new SimpleContent("Saves Time", 
			"Providing information to your customers takes time, whether it’s on the phone, face-to-face, in a "
			+ "brochure, or in emails. With an online catalogue you can provide lots of information about your "
			+ "products and services. Once your website is up and running, it is available to your customers indefinitely, "
			+ "saving you time. And what is time? Time is money!");
	
	public List<SimpleContent> reasonList() {
		List<SimpleContent> reasons = new ArrayList<SimpleContent>();
		reasons.add(credibility);
		reasons.add(saveMoney);
		reasons.add(alwaysOpen);
		reasons.add(wideAudience);
		reasons.add(saveTime);
		return reasons;
	}
	
	/* add new reasons to table */
	
	@Autowired
	private ReasonsRepository reasonsRepo;
	
	public String addNewReason(String title, String description) {
		Reason reason = new Reason(title, description);
		reasonsRepo.save(reason);
		String saved = "The reason, " + title + ", has been saved.";
		return saved;
	}
	
	public String deleteReason(Long id) {
		String title = reasonsRepo.findById(id).getName();
		reasonsRepo.delete(id);
		String saved = "The reason, " + title + ", has been deleted.";
		return saved;
	}
	
	public List<Reason> listOfReasons() {
		return reasonsRepo.findAll();
	}

	/* adding page context, usually just a header and paragraph */
	
	@Autowired
	private HomeContextRepository contextRepo;
	
	public String addNewContext(String title, String description) {
		HomeContext context = new HomeContext(title, description);
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
	public List<HomeContext> listOfContext() {
		return contextRepo.findAll();
	}
	
	/* load context for page */
	public SimpleContent loadSpecificContext() {
		Long id = (long) contextRepo.findAll().size() -1;
		if (id < 0) {
			return null;
		}
		return contextRepo.findById(id);
	}
}
