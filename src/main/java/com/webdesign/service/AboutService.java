package com.webdesign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webdesign.model.AboutContext;
import com.webdesign.model.SimpleContent;
import com.webdesign.repository.AboutContextRepository;

@Service
@Qualifier("aboutService")
public class AboutService {

	private SimpleContent aboutMe = new SimpleContent("https://s3-us-west-2.amazonaws.com/spa-blue/web-design/img/profile-pic.png",
			"Jason Bierbrauer",
			"I am a freelance web designer and software developer. Coding began as a hobby of mine that "
			+ "quickly grew into a passion. I am now fully self employed building business solutions for "
			+ "small businesses. Besides software, I also support myself by contracting small masonry side jobs, care-taking of the "
			+ "property my family and I live on, and anything else that will help pay the bills."
			+ "<br/><br/>"
			+ "Family time every weekend almost always consists of outdoor activities whether it is hiking beautiful trails"
			+ " in some of Missouri's wonderful state parks or canoeing down the Meremac river to playing with our goats on "
			+ "our small hobby farm. I also enjoy riding my motorcycle on rural country roads. I like the back roads because "
			+ "there are a lot less other vehicles on the road which means less chances of being hit by drivers on their cell "
			+ "phones! I just enjoy cruising and taking in the beautiful scenery.");
	
	public List<SimpleContent> aboutMeInfo() {
		List<SimpleContent> about = new ArrayList<SimpleContent>();
		about.add(aboutMe);
		return about;
	}
	
	
	/* adding page context, usually just a header and paragraph */
	
	@Autowired
	private AboutContextRepository contextRepo;
	
	public String addNewContext(String url, String title, String description) {
		AboutContext context = new AboutContext(url, title, description);
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
	public List<AboutContext> listOfContext() {
		return contextRepo.findAll();
	}
	
	/* load context for page */
	public AboutContext loadSpecificContext() {
		Long id = (long) contextRepo.findAll().size() -1;
		if (id < 0) {
			return null;
		}
		return contextRepo.findById(id);
	}
}
