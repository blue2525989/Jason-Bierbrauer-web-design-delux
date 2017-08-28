package com.webdesign.model;

import javax.persistence.Entity;

@Entity
public class ServicesContext extends SimpleContent {

	public ServicesContext(String title, String description) {
		super.setName(title);
		super.setDescription(description);
	}
	


}
