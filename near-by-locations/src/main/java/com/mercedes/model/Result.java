package com.mercedes.model;

import java.util.List;

//This Model holds List of Items for each selected category.
public class Result {
	private String next;
	private List<Item> items;
	
	public Result() {
		super();
	}
	public Result(String next, List<Item> items) {
		super();
		this.next = next;
		this.items = items;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Result [next=" + next + ", items=" + items + "]";
	}
	
}
