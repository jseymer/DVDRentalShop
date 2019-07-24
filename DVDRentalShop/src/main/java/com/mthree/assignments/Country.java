package com.mthree.assignments;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country {
	
	@Id
	@Column(name = "country_id")
	private long countryId;
	@Column(name = "countryName")
	private String countryName;
	
	@OneToMany(mappedBy = "country")
    private List<City> cities = new ArrayList<>();
	
	public Country(long countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String toString() {
		return "Country: " + this.getCountryName();
	}
	

}
