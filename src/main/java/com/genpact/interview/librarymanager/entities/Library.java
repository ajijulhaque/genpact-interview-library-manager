package com.genpact.interview.librarymanager.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genpact.interview.librarymanager.enums.LIB_ITEM_TYPE;

@Entity
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long libraryId;
	private String name;
	private String description;
	private LIB_ITEM_TYPE type;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date lastUpdatedOn;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="library")
	@JsonIgnore
	private List<Book> books;
	
	public LIB_ITEM_TYPE getType() {
		return type;
	}
	public void setType(LIB_ITEM_TYPE type) {
		this.type = type;
	}
	public long getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(long libraryId) {
		this.libraryId = libraryId;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
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
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
}
