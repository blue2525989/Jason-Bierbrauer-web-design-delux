package com.webdesign.model;

import javax.persistence.Entity;

@Entity
public class Project extends SimpleContent {

	public Project(String url, String title, String description) {
		super.setUrl(url);
		super.setName(title);
		super.setDescription(description);
	}
	


}
