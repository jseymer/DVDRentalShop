package com.mthree.assignments;

import java.sql.Timestamp;

public class Rental {
	private long rentalId;
	private Timestamp rentalDate;
	private long inventoryId;
	private long customerId;
	private Timestamp returnDate;
	private long staffId;
	private Timestamp lastUpdate;
	
	public long getRentalId() {
		return rentalId;
	}
	public void setRentalId(long rentalId) {
		this.rentalId = rentalId;
	}
	public Timestamp getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Timestamp rentalDate) {
		this.rentalDate = rentalDate;
	}
	public long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public Timestamp getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
