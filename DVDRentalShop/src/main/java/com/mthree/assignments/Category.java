package com.mthree.assignments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@Column(name = "Category_ID")
	private long categoryID;
	
	@Column(name = "Name")
	private String name;
	
	public Category(long categoryID, String name) {
		this.setCategoryID(categoryID);
		this.setName(name);
	}
	
	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
