package com.lmig.gfc.invoicify.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.lmig.gfc.invoicify.models.BillingRecord;
import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@Controller
@RequestMapping("/billing-records")
public class BillingRecordController {
	
	public BillingRecordController(BillingRecordRepository billingRecordRepository, CompanyRepository companyRepository) {
		this.billingRecordRepository = billingRecordRepository;
		this.companyRepository = companyRepository;
	}

	private BillingRecordRepository billingRecordRepository;
	private CompanyRepository companyRepository;

	@GetMapping("")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("billing-records/list");
		
		// Get all the billing records and add them to the model and view with the key "records"
		List<BillingRecord> records = billingRecordRepository.findAll();
		mv.addObject("records", records);
		
		// Get all the companies and add them to the model and view with the key "companies"
		List<Company> companies = companyRepository.findAll();
		mv.addObject("companies", companies);
	
		return mv;
		
	
	}


	public BillingRecordRepository getBillingRecordRepository() {
		return billingRecordRepository;
	}


	public void setBillingRecordRepository(BillingRecordRepository billingRecordRepository) {
		this.billingRecordRepository = billingRecordRepository;
	}


	public CompanyRepository getCompanyRepository() {
		return companyRepository;
	}


	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	


	
	
		
}
