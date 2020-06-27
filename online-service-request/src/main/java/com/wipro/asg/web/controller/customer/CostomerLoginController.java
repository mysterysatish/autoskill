package com.wipro.asg.web.controller.customer;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.asg.enums.Status;
import com.wipro.asg.model.VendorServiceRegistration;
import com.wipro.asg.service.ValidationService;
import com.wipro.asg.service.VendorRegitrationService;

@Controller
public class CostomerLoginController {
	
	@Autowired
	private ValidationService validationService;
	@Autowired
	private VendorRegitrationService vendorRegistrationService;
	
	
	@GetMapping("/login")
	public String showLogin(ModelMap modelmap)
	{
		System.out.println("Inside controller");
		return "CustomerLogin";
		
	}
	
	@PostMapping("/login")
	public String showWecome(ModelMap modelmap,@RequestParam String name, @RequestParam String password,HttpServletRequest request)
	{
		System.out.println("Inside controller");
		//System.out.println(validationService.validateService(name, password));
		
		boolean isCustomer = false;
		boolean isVendor = false;
		String showview = null;
		
		// for Customer
		isCustomer = validationService.validateCustomerCredentialService(name, password);
	    isVendor = validationService.ValidateVendorCredentials(name, password);
		
	    System.out.println("Is Vendor"+isVendor);
		if(!isCustomer && !isVendor)
		{
			modelmap.put("errorMessage", "Invalid Input")	;
			System.out.println("Invalid credential");
			showview= "CustomerLogin";
		}
		
		if(isCustomer) {
		
			showview= "CustomerSearchVendor";
		}
		
		if(isVendor) {
			
			System.out.println("Inside Vendor");
			modelmap.put("vendorName", name)	;
			
			
			HttpSession session = request.getSession();
			session.setAttribute("userid",name);
			
	//		HttpSession session = request.getSession();
		//	String vendorId = name;
			
		
			if(name != null) {
			ArrayList<VendorServiceRegistration> filteredbookedVendors = 
					(ArrayList<VendorServiceRegistration>) vendorRegistrationService.retriveBookedVendor().stream().filter(e -> e.getVendorId().equals(name) && e.getStatus().equals(Status.PENDING.toString())).collect(Collectors.toList());
			
			System.out.println("Vendor Id"+name);
			
		//	bookVendors
			modelmap.put("bookVendors", filteredbookedVendors)	;
	for (VendorServiceRegistration vendorServiceRegistration : filteredbookedVendors) {
				
				System.out.println(vendorServiceRegistration);
			}
	
	if(filteredbookedVendors.size() == 0)
	{
		modelmap.put("errorMessage", "No pending records found")	;	
		
	}
			}

			
			showview= "VendorWelcome";
			}
		return showview;
	}
	
	

}
