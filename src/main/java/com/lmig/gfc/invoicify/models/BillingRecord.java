package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

// This needs to be an entity
@Entity
public abstract class BillingRecord {

	// This needs an id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// This needs a user named createdBy
	@ManyToOne
	private User createdBy;
	
	// This needs a name;
	private String name;
	
	// This needs a string named description
	private String description;
	
	// This needs an invoice line item named lineItem. It should be a one-to-one
	// relationship mapped by billingRecord
	@OneToOne(mappedBy = "billingRecord")
	private InvoiceLineItem lineItem; 
	
	// This needs a company named client that is a many-to-one relationship
	@ManyToOne
	private Company client;
	
	// This needs an abstract method that returns a double named getTotal()
	public abstract double getTotal();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InvoiceLineItem getInvoiceLineItem() {
		return lineItem;
	}

	public void setInvoiceLineItem(InvoiceLineItem invoiceLineItem) {
		this.lineItem = invoiceLineItem;
	}

	public Company getClient() {
		return client;
	}

	public void setClient(Company client) {
		this.client = client;
	}

		// All the getters and setters
}
