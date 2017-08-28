package com.webdesign.model;

import javax.persistence.Entity;

@Entity
public class Reason extends SimpleContent {

	public Reason(String title, String description) {
		super.setName(title);
		super.setDescription(description);
	}
	


}
