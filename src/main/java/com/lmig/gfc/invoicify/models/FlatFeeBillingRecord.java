package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;

// This needs to be an entity
@Entity
public class FlatFeeBillingRecord extends BillingRecord {
	
	private double amount;

	@Override
	public double getTotal() {
		return  amount;
	}

	// This does NOT need an id because it inherits it from the BillingRecord class
	// This needs a double field named amount
	
		public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	// This needs to override the getTotal() method and return the amount
	// This needs getters and setters
	

	}

