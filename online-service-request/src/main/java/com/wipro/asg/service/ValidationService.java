package com.wipro.asg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.asg.model.Vendor;

@Component
public class ValidationService {
	
	@Autowired
	VendorRegitrationService vendorRegistrationService;
	
	
	
	public boolean validateService(String name , String password)
	{
		boolean isValid= false;
		
		if(name.length()<=16 && name.length() >=8) {
			isValid = true;
			System.out.println("Valid NAme");
			
		}
		
		if(password.length()<=16 && password.length() >=8) {
			isValid = true;
			System.out.println("Valid Password");
		}
		
		return isValid;
		
	}
	
	public boolean validateCustomerCredentialService(String name , String password)
	{
		boolean isValid= false;
		

		
	  
		if(name.equals("customer") && password.equals("customer123"))
		{
			isValid = true;
		}
		
		return isValid;
		
	}
	
	public boolean ValidateVendorCredentials(String name,String password)
	{
      ArrayList<Vendor> vendors ;
      boolean isVendor = false;
      vendors = vendorRegistrationService.retriveVenfor();
      
      System.out.println("Vendor Credential check list"+ vendors);
      System.out.println("Vendor Credentail name"+ name);
      System.out.println("Vendor Credntial password"+password);
      for (Vendor vendor : vendors) {
    	  
    	  if(vendor.getId().equals(name) && vendor.getPassword().equals(password)) {
    		  isVendor = true;
    		  break;
    	  }
    	  
		
	}
      return isVendor;
	}

}
