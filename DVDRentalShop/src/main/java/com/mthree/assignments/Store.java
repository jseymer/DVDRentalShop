package com.mthree.assignments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Store")
public class Store {
	
	@Id
	@Column(name = "Store_ID")
	private long storeID;
	
	@Column(name = "Manager_Staff_ID")
	private long managerStaffID;
	
	@Column(name = "Address_ID")
	private long addressID;
	
	public Store(long storeID, long managerStaffID, long addressID) {
		this.setStoreID(storeID);
		this.setManagerStaffID(managerStaffID);
		this.setAddressID(addressID);
	}

	public long getStoreID() {
		return storeID;
	}

	public void setStoreID(long storeID) {
		this.storeID = storeID;
	}

	public long getManagerStaffID() {
		return managerStaffID;
	}

	public void setManagerStaffID(long managerStaffID) {
		this.managerStaffID = managerStaffID;
	}

	public long getAddressID() {
		return addressID;
	}

	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}


}
