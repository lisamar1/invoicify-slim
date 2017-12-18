package com.lmig.gfc.invoicify.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

// Controller advice does something for every single controller in the application
@ControllerAdvice
public class UserModelAdvice {

	// A model attribute is used to add something to the model and view
	// for every single request in the application.
	@ModelAttribute
	public void addUserToAllModels(Model model, Authentication auth) {
		if (auth != null) {
			model.addAttribute("user", auth.getPrincipal());
		}
	}

}