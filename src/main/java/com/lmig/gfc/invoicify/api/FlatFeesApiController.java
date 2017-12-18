package com.lmig.gfc.invoicify.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@RestController
@RequestMapping("/api/billing-records/flats")
public class FlatFeesApiController {

	private CompanyRepository companyRepository;
	private BillingRecordRepository billingRecordRepository;


    public FlatFeesApiController(CompanyRepository companyRepository,
			BillingRecordRepository billingRecordRepository) {
		this.companyRepository = companyRepository;
		this.billingRecordRepository = billingRecordRepository;
	}

    @PostMapping
    public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord flatFeeBillingRecord, Authentication auth) {
		// Get the user from the auth.getPrincipal() method
		User user = (User) auth.getPrincipal();
		// Find the client using the client id
		Company client = companyRepository.findOne(flatFeeBillingRecord.getClient().getId());		
		// Set the client on the record
		flatFeeBillingRecord.setClient(client);	
		
		// Set the user on the record for the created by property
		flatFeeBillingRecord.setCreatedBy(user);
		// Save the record
		return billingRecordRepository.save(flatFeeBillingRecord);

    }

}