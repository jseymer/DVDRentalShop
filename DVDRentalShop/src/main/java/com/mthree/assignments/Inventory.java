package com.mthree.assignments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inventory")
public class Inventory {
	
	@Id
	@Column(name = "Inventory_ID")
	private long inventoryID;
	
	@Column(name = "Film_ID")
	private long filmID;
	
	@Column(name = "Store_ID")
	private long storeID;
	
	public Inventory() {
		super();
	}
	
	public Inventory(long inventoryID, long filmID, long storeID) {
		super();
		this.setInventoryID(inventoryID);
		this.setFilmID(filmID);
		this.setStoreID(storeID);
	}

	public long getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(long inventoryID) {
		this.inventoryID = inventoryID;
	}

	public long getFilmID() {
		return filmID;
	}

	public void setFilmID(long filmID) {
		this.filmID = filmID;
	}

	public long getStoreID() {
		return storeID;
	}

	public void setStoreID(long storeID) {
		this.storeID = storeID;
	}
	
	public String toString() {
		return "This inventory item ID is: " + getInventoryID() + " and the film ID is: " + getFilmID() + " and it is from store number: " + getStoreID();
	}

}
