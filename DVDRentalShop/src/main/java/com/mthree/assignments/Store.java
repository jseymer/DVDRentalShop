package com.mthree.assignments;

public class Store {
	
	private long storeID;
	private long managerStaffID;
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
