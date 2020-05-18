package com.genpact.interview.librarymanager.models;

import com.genpact.interview.librarymanager.enums.LIB_ITEM_TYPE;

public class LibraryModel {
	private String name;
	private String description;
	private LIB_ITEM_TYPE type;
	private long libId;
	
	public long getLibId() {
		return libId;
	}
	public void setLibId(long libId) {
		this.libId = libId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String deescription) {
		this.description = deescription;
	}
	public LIB_ITEM_TYPE getType() {
		return type;
	}
	public void setType(LIB_ITEM_TYPE type) {
		this.type = type;
	}
}
