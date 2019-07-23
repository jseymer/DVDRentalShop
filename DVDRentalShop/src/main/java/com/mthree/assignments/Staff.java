package com.mthree.assignments;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Staff")
public class Staff {
	
	@Id
	@Column(name = "staff_id")
	private long staffId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "address_id")
	private long addressId;
	@Column(name = "email")
	private String email;
	@Column(name = "store_id")
	private long storeId;
	@Column(name = "active")
	private long active;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	
	public Staff(long staffId, String firstName, String lastName, long addressId, String email, long storeId,
			long active, String username, String password) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressId = addressId;
		this.email = email;
		this.storeId = storeId;
		this.active = active;
		this.username = username;
		this.password = password;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	public long getActive() {
		return active;
	}
	public void setActive(long active) {
		this.active = active;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "Staff: " + this.getFirstName() + " " + this.getLastName();
	}

}
