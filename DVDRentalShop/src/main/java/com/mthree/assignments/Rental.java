package com.mthree.assignments;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rental")
public class Rental {
	
	@Id
	@Column(name = "rental_id")
	private long rentalId;
	@Column(name = "rental_date")
	private LocalDateTime rentalDate;
	@Column(name = "inventory_id")
	private long inventoryId;
	@Column(name = "customer_id")
	private long customerId;
	@Column(name = "return_date")
	private LocalDateTime returnDate;
	@Column(name = "staff_id")
	private long staffId;
	@Column(name = "last_update")
	private LocalDateTime lastUpdated;
	
	
	
	public Rental() {
		super();
	}
	public Rental(long rentalId, LocalDateTime rentalDate, long inventoryId, long customerId, LocalDateTime returnDate, long staffId, LocalDateTime lastUpdated) {
		super();
		this.rentalId = rentalId;
		this.rentalDate = rentalDate;
		this.inventoryId = inventoryId;
		this.customerId = customerId;
		this.returnDate = returnDate;
		this.staffId = staffId;
		this.lastUpdated = lastUpdated;
	}
	public long getRentalId() {
		return rentalId;
	}
	public void setRentalId(long rentalId) {
		this.rentalId = rentalId;
	}
	public LocalDateTime getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(LocalDateTime rentalDate) {
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
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	@Override
	public String toString() {
		return "Rental [rentalId=" + rentalId + ", rentalDate=" + rentalDate + ", inventoryId=" + inventoryId
				+ ", customerId=" + customerId + ", returnDate=" + returnDate + ", staffId=" + staffId + "]";
	}
	
	

}
