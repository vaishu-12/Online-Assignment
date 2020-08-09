package com.mercedes.model;
//Category is the part of Items data.
public class Category {
	
	private String id;
	private String title;
	private String href;
	private String type;
	private String system;
	
	public Category() {
		super();
	}

	public Category(String id, String title, String href, String type, String system) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.type = type;
		this.system = system;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + ", href=" + href + ", type=" + type + ", system=" + system
				+ "]";
	}
	
	
}
