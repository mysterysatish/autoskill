package com.wipro.asg.web.controller.vendor;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.asg.enums.Status;
import com.wipro.asg.model.VendorServiceRegistration;
import com.wipro.asg.service.VendorRegitrationService;

@Controller
public class VendorResource {

	
	@Autowired
	private VendorRegitrationService vendorRegistrationService;
	
	@GetMapping("vendorHome")
	
	public String showVendorHomePage(ModelMap modelmap,HttpServletRequest request) {
	//	String vendorId;
		
	//	vendorId = (String) modelmap.get("vendorName")	;
		
	//	ArrayList<VendorServiceRegistration> bookedVendors = vendorRegistrationService.retriveBookedVendor();
		
		HttpSession session = request.getSession();
		String vendorId = (String) session.getAttribute("userid");
	
		
		if(vendorId != null) {
			ArrayList<VendorServiceRegistration> filteredbookedVendors = 
					(ArrayList<VendorServiceRegistration>) vendorRegistrationService.retriveBookedVendor().stream().filter(e -> e.getVendorId().equals(vendorId) && e.getStatus().equals(Status.PENDING.toString())).collect(Collectors.toList());
			
			System.out.println("Vendor Id"+vendorId);
			
		//	bookVendors
			for (VendorServiceRegistration vendorServiceRegistration : filteredbookedVendors) {
				
				System.out.println(vendorServiceRegistration);
			}
			
			if(filteredbookedVendors.size() == 0)
			{
				modelmap.put("errorMessage", "No pending records found")	;	
				
			}
			modelmap.put("bookVendors", filteredbookedVendors)	;
			return "VendorWelcome";
			}
		
		else {
			return "redirect:/login";
		}
		
		
	}
	
	@PostMapping("/vendorHome") 
	public String handleVendorBookPost(ModelMap modelmap,@RequestParam Map<String,String> allParams) {
		
		String id = allParams.get("id");
		
		System.out.println("ID"+id);
		System.out.println(allParams);
		
		String requestId = allParams.get("requestId"+id);
		String status  = allParams.get("status"+id);
		System.out.println(id+requestId+status);
		
		ArrayList<VendorServiceRegistration> vendors = vendorRegistrationService.retriveBookedVendor();
		System.out.println("Boked Vendors"+vendors);
		for (VendorServiceRegistration vendorServiceRegistration : vendors) {
			
			if(vendorServiceRegistration.getRequestId() == Integer.parseInt(requestId)) {
				vendorServiceRegistration.setStatus(status);	
				break;
			}
			
		}
		
		return "redirect:/vendorHome";
		

		
	}
	
	
	@GetMapping("archived")
	
	public String showArchivedRequest(ModelMap modelmap,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String vendorId = (String) session.getAttribute("userid");
		System.out.println(vendorId);
		if(vendorId != null) {
		
		ArrayList<VendorServiceRegistration> archivedVendors = 
				 (ArrayList<VendorServiceRegistration>) vendorRegistrationService.retriveBookedVendor()
		.stream()
		.filter(e -> 
		e.getStatus().equals(Status.APPROVE.toString()) || 
		e.getStatus().equals(Status.REJECT.toString() ))
		.filter(e -> e.getVendorId().equals(vendorId))
		.collect(Collectors.toList());
		
		if(archivedVendors.size() == 0)
		{
			modelmap.put("errorMessage", "No archived requests found")	;	
		}
		modelmap.put("bookVendors", archivedVendors)	;
		
		return "VendorArchive";
		}
		else {
		return "redirect:/login";
		}
	}
}
