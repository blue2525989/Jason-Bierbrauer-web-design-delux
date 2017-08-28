package com.webdesign.model;

import javax.persistence.Entity;

@Entity
public class AboutContext extends SimpleContent {

	public AboutContext(String url, String title, String description) {
		super.setUrl(url);
		super.setName(title);
		super.setDescription(description);
	}
	


}
