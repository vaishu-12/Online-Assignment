package com.mercedes.model;
//OpeningHours is the part of Items data.
public class OpeningHours {
	private String text;
	private String label;
	private Boolean isOpen;
	
	
	public OpeningHours() {
		super();
	}


	public OpeningHours(String text, String label, Boolean isOpen) {
		super();
		this.text = text;
		this.label = label;
		this.isOpen = isOpen;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public Boolean getIsOpen() {
		return isOpen;
	}


	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}


	@Override
	public String toString() {
		return "OpeningHours [text=" + text + ", label=" + label + ", isOpen=" + isOpen + "]";
	}
	
	
}
