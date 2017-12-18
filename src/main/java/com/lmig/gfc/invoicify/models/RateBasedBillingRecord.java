package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;

//This needs to be an entity
@Entity
public class RateBasedBillingRecord extends BillingRecord {

	@Override
	public double getTotal() {
		return rate * quantity;
	}

	// This does NOT need an id because it inherits it from the BillingRecord class
	// This needs a double field named rate
	private double rate;
	
	// This needs a double field named quantity
	
	private double quantity;

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
	// This needs to override the getTotal() method and return the product of the rate and quantity
	
	// This needs getters and setters
	
}