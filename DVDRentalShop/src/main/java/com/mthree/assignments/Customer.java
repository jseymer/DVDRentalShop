package com.mthree.assignments;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@Column(name = "customer_id")
	private long customerId;
	@Column(name = "store_id")
	private long storeId;
	@Column(name = "first_name")
	private String fName;
	@Column(name = "last_name")
	private String lName;
	@Column(name = "address_id")
	private long addressId;
	@Column(name = "email")
	private String email;
	@Column(name = "active")
	private boolean active;
	@Column(name = "create_date")
	private LocalDateTime startDate;

	public Customer() {
		super();
	}

	public Customer(long customerId, long storeId, long addressId, String fName, String lName, String email,
			boolean active, LocalDateTime startDate) {
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

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
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

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public String toString() {
		return "Customer: " + this.getfName() + " " + this.getlName() + ", " + this.getEmail() + ", "
				+ this.getStartDate();
	}

}
