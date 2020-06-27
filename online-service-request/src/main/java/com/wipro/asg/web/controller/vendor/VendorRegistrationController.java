package com.wipro.asg.web.controller.vendor;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wipro.asg.model.Vendor;
import com.wipro.asg.service.VendorRegitrationService;

@Controller
public class VendorRegistrationController {
	
	@Autowired
	private VendorRegitrationService vendorRegistrationService;
	
	@GetMapping("/register")
	public String showVendorRegistration(ModelMap modelmap)
	{
		System.out.println("Inside controller");
		return "VendorRegister";
		
	}
	
	@PostMapping("/register")
	public String showLogin(ModelMap modelmap,Vendor vendor)
	{
		//System.out.println(modelmap.);
		
		boolean isIDExist= false;
		
		ArrayList<Vendor> vendors;
		System.out.println(vendor);
		vendors = vendorRegistrationService.retriveVenfor();
		
	    for (Vendor vendor2 : vendors) {
	    	
	    	if(vendor2.getId().equals(vendor.getId()))
	    	{
	    		isIDExist = true	;
	    		break;
	    		

	    		
	    	}
			
		}
	    
	    if(isIDExist == true)
	    {
			modelmap.put("errorMessage", "User-ID already exist")	;
			System.out.println("User Id exist");
			return "VendorRegister";
	    	
	    }
	    
	    System.out.println(vendor);
		
		vendorRegistrationService.addRegistration(vendor);
		System.out.println("Total Vendors"+vendorRegistrationService.retriveVenfor());
		return "CustomerLogin";
	}

}
