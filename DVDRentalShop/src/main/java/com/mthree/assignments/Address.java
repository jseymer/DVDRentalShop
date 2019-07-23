package com.mthree.assignments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	
	@Id
	@Column(name = "Address_ID")
	private long addressID;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Address_2")
	private String address2;
	
	@Column(name = "District")
	private String district;
	
	@Column(name = "City_ID")
	private long cityID;
	
	@Column(name = "Postal_Code")
	private String postalCode;
	
	@Column(name = "Phone")
	private String phone;
	
	@ManyToOne
    @JoinColumn(name="City_ID")
    private City city;

	public Address(long addressID, String address, long cityID, String postalCode) {
		this.setAddressID(addressID);
		this.setAddress(address);
		this.setCityID(cityID);
		this.setPostalCode(postalCode);
	}

	public long getAddressID() {
		return addressID;
	}

	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public long getCityID() {
		return cityID;
	}

	public void setCityID(long cityID) {
		this.cityID = cityID;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String toString() {
		return "Address: " + this.getAddress() + " " + this.getPostalCode();
	}
	
}
