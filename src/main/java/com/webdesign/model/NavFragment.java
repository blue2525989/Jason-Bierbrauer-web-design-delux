package com.webdesign.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class NavFragment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min=2, max=16)
	private String homeButton;
	
	@NotNull
	@Size(min=2, max=16)
	private String servicesButton;
	
	@NotNull
	@Size(min=2, max=16)
	private String contactButton;
	
	@NotNull
	@Size(min=2, max=16)
	private String aboutButton;
	
	@NotNull
	@Size(min=2, max=16)
	private String projectsButton;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHomeButton() {
		return homeButton;
	}

	public void setHomeButton(String homeButton) {
		this.homeButton = homeButton;
	}

	public String getServicesButton() {
		return servicesButton;
	}

	public void setServicesButton(String servicesButton) {
		this.servicesButton = servicesButton;
	}

	public String getContactButton() {
		return contactButton;
	}

	public void setContactButton(String contactButton) {
		this.contactButton = contactButton;
	}

	public String getAboutButton() {
		return aboutButton;
	}

	public void setAboutButton(String aboutButton) {
		this.aboutButton = aboutButton;
	}

	public String getProjectsButton() {
		return projectsButton;
	}

	public void setProjectsButton(String projectsButton) {
		this.projectsButton = projectsButton;
	}
}
