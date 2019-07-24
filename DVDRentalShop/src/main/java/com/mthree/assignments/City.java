package com.mthree.assignments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class City {
	
	@Id
	@Column(name = "city_id")
	private long cityId;
	@Column(name = "city")
	private String cityName;
	@Column(name = "country_id")
	private long countryId;
	
	/*@OneToMany(mappedBy = "city")
    private List<Address> addresses = new ArrayList<>();
	*/
	/*@ManyToOne
    @JoinColumn(name="Country_ID")
    private Country country;*/
	
	public City() {
		super();
	}
	
	public City(long cityId, String cityName, long countryId) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.countryId = countryId;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	
	public String toString() {
		return "City: " + this.getCityName();
	}

}
