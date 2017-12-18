package com.lmig.gfc.invoicify.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.models.RateBasedBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@RestController
@RequestMapping("/api/billing-records/rates")
public class RateFeesApiController {

	private CompanyRepository companyRepository;
	private BillingRecordRepository billingRecordRepository;

	public RateFeesApiController(CompanyRepository companyRepository,
			BillingRecordRepository billingRecordRepository) {
		this.companyRepository = companyRepository;
		this.billingRecordRepository = billingRecordRepository;
	}

	@PostMapping
	public RateBasedBillingRecord create(@RequestBody RateBasedBillingRecord rateBasedBillingRecord, Authentication auth) {
		// Get the user from the auth.getPrincipal() method
		User user = (User) auth.getPrincipal();
		// Find the client using the client id
		Company client = companyRepository.findOne(rateBasedBillingRecord.getClient().getId());		
		// Set the client on the record
		rateBasedBillingRecord.setClient(client);	
		
		// Set the user on the record for the created by property
		rateBasedBillingRecord.setCreatedBy(user);
		// Save the record
		return billingRecordRepository.save(rateBasedBillingRecord);

	}

}