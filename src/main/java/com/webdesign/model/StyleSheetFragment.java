package com.webdesign.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;

@Entity
public class StyleSheetFragment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=4, max=7)
	private String backgroundColor;
	
	@NotNull
	@Size(min=4, max=15)
	private String headerBackgroundColor;
	
	@NotNull
	@Size(min=4, max=15)
	private String textColor;
	
	@NotNull
	@Size(min=4, max=15)
	private String mainContentBackgroundColor;
	
	@NotNull
	@Size(min=4, max=15)
	private String evenTableBackgroundColor;
	
	@NotNull
	@Size(min=4, max=15)
	private String oddTableBackGroundColor;
	
	@NotNull
	@Size(min=4, max=15)
	private String linkColor;

	public StyleSheetFragment(String backgroundColor, String headerBackgroundColor, String textColor,
			String mainContentBackgroundColor, String evenTableBackgroundColor, String oddTableBackgroundColor,
			String linkColor) {
		this.setBackgroundColor(backgroundColor);
		this.setHeaderBackgroundColor(headerBackgroundColor);
		this.setTextColor(textColor);
		this.setMainContentBackgroundColor(mainContentBackgroundColor);
		this.setEvenTableBackgroundColor(evenTableBackgroundColor);
		this.setOddTableBackGroundColor(oddTableBackgroundColor);
		this.setLinkColor(linkColor);
	}
	
	public StyleSheetFragment() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public String getMainContentBackgroundColor() {
		return mainContentBackgroundColor;
	}

	public void setMainContentBackgroundColor(String mainContentBackgroundColor) {
		this.mainContentBackgroundColor = mainContentBackgroundColor;
	}

	public String getEvenTableBackgroundColor() {
		return evenTableBackgroundColor;
	}

	public void setEvenTableBackgroundColor(String evenTableBackgroundColor) {
		this.evenTableBackgroundColor = evenTableBackgroundColor;
	}

	public String getOddTableBackGroundColor() {
		return oddTableBackGroundColor;
	}

	public void setOddTableBackGroundColor(String oddTableBackGroundColor) {
		this.oddTableBackGroundColor = oddTableBackGroundColor;
	}

	public String getLinkColor() {
		return linkColor;
	}

	public void setLinkColor(String linkColor) {
		this.linkColor = linkColor;
	}

	public String getHeaderBackgroundColor() {
		return headerBackgroundColor;
	}

	public void setHeaderBackgroundColor(String headerBackgroundColor) {
		this.headerBackgroundColor = headerBackgroundColor;
	}
}
