package com.webdesign.model;

import javax.persistence.Entity;

@Entity
public class HomeContext extends SimpleContent {

	public HomeContext(String title, String description) {
		super.setName(title);
		super.setDescription(description);
	}
	


}
