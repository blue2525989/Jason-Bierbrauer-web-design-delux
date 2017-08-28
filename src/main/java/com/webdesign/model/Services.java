package com.webdesign.model;

import javax.persistence.Entity;

@Entity
public class Services extends SimpleContent {

	public Services(String url, String title, String description) {
		super.setUrl(url);
		super.setName(title);
		super.setDescription(description);
	}
	


}
