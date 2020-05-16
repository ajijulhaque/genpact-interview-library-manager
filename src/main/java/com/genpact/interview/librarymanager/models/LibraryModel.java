package com.genpact.interview.librarymanager.models;

import com.genpact.interview.librarymanager.enums.LIB_ITEM_TYPE;

public class LibraryModel {
	private String name;
	private String deescription;
	private LIB_ITEM_TYPE type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeescription() {
		return deescription;
	}
	public void setDeescription(String deescription) {
		this.deescription = deescription;
	}
	public LIB_ITEM_TYPE getType() {
		return type;
	}
	public void setType(LIB_ITEM_TYPE type) {
		this.type = type;
	}
}
