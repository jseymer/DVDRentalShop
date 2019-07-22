package com.mthree.assignments;


public class Inventory {
	
	private long inventoryID;
	private long filmID;
	private long storeID;
	
	public Inventory(long inventoryID, long filmID, long storeID) {
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
