package com.mthree.assignments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Film_Category")
public class FilmCategory {

	@Id
	@Column(name = "Film_ID")
	private long filmID;
	
	@Column(name = "Category_ID")
	private long categoryID;
	
	public FilmCategory() {
		super();
	}

	public FilmCategory(long filmID, long categoryID) {
		super();
		this.setFilmID(filmID);
		this.setCategoryID(categoryID);
	}
	
	public long getFilmID() {
		return filmID;
	}

	public void setFilmID(long filmID) {
		this.filmID = filmID;
	}

	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

}
