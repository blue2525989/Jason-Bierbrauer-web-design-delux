package com.webdesign.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webdesign.model.Project;
import com.webdesign.model.ProjectsContext;
import com.webdesign.repository.ProjectsContextRepository;
import com.webdesign.repository.ProjectsRepository;

@Service
@Qualifier("projectsService")
public class ProjectsService {
		
	@Autowired
	private ProjectsRepository projectRepo;
	
	public String addNewProject(String url, String title, String description) {
		Project project = new Project(url, title, description);
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
	
	public List<Project> listOfProjects() {
		return projectRepo.findAll();
	}
	
	/* adding page context, usually just a header and paragraph */
	
	@Autowired
	private ProjectsContextRepository contextRepo;
	
	public String addNewContext(String title, String description) {
		ProjectsContext context = new ProjectsContext(title, description);
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
	public List<ProjectsContext> listOfContext() {
		return contextRepo.findAll();
	}
	
	/* load context for page */
	public List<ProjectsContext> loadSpecificContext() {
		List<ProjectsContext> listFull = contextRepo.findAll();
		List<ProjectsContext> list = new ArrayList<ProjectsContext>();
		try {
			list.add(listFull.get(listFull.size()-1));
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		
		return list;
	}
}
