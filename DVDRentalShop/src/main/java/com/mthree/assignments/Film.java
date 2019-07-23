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
	private long year;
	
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
	
	public Film(long filmId, long year, long rentDuration, long length, String title, String description, String rating,
			String features, BigDecimal rate, BigDecimal replaceCost) {
		super();
		this.filmId = filmId;
		this.year = year;
		this.rentDuration = rentDuration;
		this.length = length;
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.features = features;
		this.rate = rate;
		this.replaceCost = replaceCost;
	}
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
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
	
}
