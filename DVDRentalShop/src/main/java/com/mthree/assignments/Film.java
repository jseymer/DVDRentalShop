package com.mthree.assignments;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Film")
public class Film {

	@Id
	@Column(name = "Film_ID")
	private long filmId;

	@Column(name = "Release_Year")
	private String year;

	@Column(name = "Rental_Duration")
	private long rentDuration;

	@Column(name = "Length")
	private long length;

	@Column(name = "Title")
	private String title;

	@Column(name = "Description")
	private String description;

	@Column(name = "Rating")
	private String rating;

	@Column(name = "Special_Features")
	private String features;

	@Column(name = "Rental_Rate")
	private BigDecimal rate;

	@Column(name = "Replacement_Cost")
	private BigDecimal replaceCost;

	@Column(name = "Language_ID")
	private long languageID;

	@Column(name = "Original_Language_ID")
	private Long originalLanguageID;

	/*
	 * @ManyToMany(mappedBy = "films") 
	 * private Set<Actor> actors = new HashSet<>();
	 * 
	 * @ManyToMany(mappedBy = "films") 
	 * private Set<Category> categories = new HashSet<>();
	 */
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="Language_ID") private Language language;
	 */

	public Film() {
		super();
	}

	public Film(long filmId, String year, long rentDuration, long length, String title, String description,
			String rating, String features, BigDecimal rate, BigDecimal replaceCost, long languageID,
			long originalLanguageID) {
		super();
		this.setFilmId(filmId);
		this.setYear(year);
		this.setRentDuration(rentDuration);
		this.setLength(length);
		this.setTitle(title);
		this.setDescription(description);
		this.setRating(rating);
		this.setFeatures(features);
		this.setRate(rate);
		this.setReplaceCost(replaceCost);
		this.setLanguageID(languageID);
		this.setOriginalLanguageID(originalLanguageID);
	}

	public long getFilmId() {
		return filmId;
	}

	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public long getRentDuration() {
		return rentDuration;
	}

	public void setRentDuration(long rentDuration) {
		this.rentDuration = rentDuration;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getReplaceCost() {
		return replaceCost;
	}

	public void setReplaceCost(BigDecimal replaceCost) {
		this.replaceCost = replaceCost;
	}

	public Long getLanguageID() {
		return languageID;
	}

	public void setLanguageID(Long languageID) {
		this.languageID = languageID;
	}

	public long getOriginalLanguageID() {
		return originalLanguageID;
	}

	public void setOriginalLanguageID(long originalLanguageID) {
		this.originalLanguageID = originalLanguageID;
	}

	public String toString() {
		return "Film: " + this.getTitle() + " Rating: " + this.getRating() + " Length " + this.getLength()
				+ " Description: " + this.getDescription() + " Features " + this.getFeatures();
	}

}
