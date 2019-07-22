package com.mthree.assignments;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "store_id")
	private int storeId;
	@Column(name = "first_name")
	private String fName;
	@Column(name = "last_name")
	private String lName;
	@Column(name = "address_id")
	private int addressId;
	@Column(name = "email")
	private String email;
	@Column(name = "active")
	private boolean active;
	@Column(name = "create_date")
	private Date startDate;
	
	
	public Customer(int customerId, int storeId, int addressId, String fName, String lName, String email,
			boolean active, Date startDate) {
		super();
		this.customerId = customerId;
		this.storeId = storeId;
		this.addressId = addressId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.active = active;
		this.startDate = startDate;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getStoreId() {
		return storeId;
	}


	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String toString() {
		return "Customer: " + this.getfName() + " " + this.getlName() + ", " + this.getEmail() + ", " + this.getStartDate();
	}
	
	
}
