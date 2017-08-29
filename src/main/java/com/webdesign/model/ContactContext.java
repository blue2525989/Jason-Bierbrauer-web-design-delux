package com.webdesign.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
public class ContactContext {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String url;
	
	@NotNull
	private String name;
	
	@Lob
	@NotNull
	private String description;
	
	public ContactContext(String name, String description) {
		this.setName(name);
		this.setDescription(description);
	}
	
	public ContactContext(String url, String name, String description) {
		this.setUrl(url);
		this.setName(name);
		this.setDescription(description);
	}
	
	public ContactContext() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
