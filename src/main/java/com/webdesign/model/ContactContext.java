package com.webdesign.model;

import javax.persistence.Entity;

@Entity
public class ContactContext extends SimpleContent {

	public ContactContext(String title, String description) {
		super.setName(title);
		super.setDescription(description);
	}
	


}
