package com.mthree.assignments;

import java.util.Date;

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
	private Date rentalDate;
	@Column(name = "inventory_id")
	private long inventoryId;
	@Column(name = "customer_id")
	private long customerId;
	@Column(name = "return_date")
	private Date returnDate;
	@Column(name = "staff_id")
	private long staffId;
	
	
	public Rental() {
		super();
	}
	public Rental(long rentalId, Date rentalDate, long inventoryId, long customerId, Date returnDate, long staffId) {
		super();
		this.rentalId = rentalId;
		this.rentalDate = rentalDate;
		this.inventoryId = inventoryId;
		this.customerId = customerId;
		this.returnDate = returnDate;
		this.staffId = staffId;
	}
	public long getRentalId() {
		return rentalId;
	}
	public void setRentalId(long rentalId) {
		this.rentalId = rentalId;
	}
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date rentalDate) {
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
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
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
