package com.webdesign.model;

import javax.persistence.Entity;

@Entity
public class ProjectsContext extends SimpleContent {

	public ProjectsContext(String title, String description) {
		super.setName(title);
		super.setDescription(description);
	}
	


}
