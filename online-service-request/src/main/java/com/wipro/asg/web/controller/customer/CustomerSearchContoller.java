package com.wipro.asg.web.controller.customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.asg.model.Vendor;
import com.wipro.asg.model.VendorServiceRegistration;
import com.wipro.asg.service.VendorRegitrationService;

@Controller
public class CustomerSearchContoller {
	
	@Autowired
	private VendorRegitrationService vendorRegistrationService;
	
	@GetMapping("/customerHomePage")
	public String showCustomerSearch(ModelMap modelmap) {
		return "CustomerSearchVendor";
		
	}
	
	@PostMapping("/customerHomePage")
	public String showCustomerServiceBooking(ModelMap modelmap,String city,String serviceType) {
		
		System.out.println("City"+ city+"Service Type"+serviceType);
		System.out.println(vendorRegistrationService.retriveVenfor());
		
		ArrayList<Vendor> vendors = vendorRegistrationService.retriveVenfor();
		//Collector collector = null;
		
		ArrayList<Vendor> filteredVendor = new ArrayList<Vendor>();
		
		ArrayList<VendorServiceRegistration> bookVendors = new ArrayList<VendorServiceRegistration>();
		filteredVendor =	(ArrayList<Vendor>) vendors.stream().filter( e -> e.getCity().equals(city) && e.getServiceType().contains(serviceType)
				).collect(Collectors.toList());
		
		
		bookVendors = (ArrayList<VendorServiceRegistration>) vendors.stream().filter( e -> e.getCity().equals(city) && e.getServiceType().contains(serviceType)
				).
				map(e -> new VendorServiceRegistration(e.getId(),e.getName(),serviceType,e.getCity()))
				.collect(Collectors.toList() );
		System.out.println("Filtered Venodrs"+bookVendors);
		
		if(filteredVendor.size() >0)
		{
			modelmap.put("bookVendors", bookVendors);
			return "CustomerServiceBooking";	
		}
		modelmap.put("errorMessage", "No records found")	;
		return "CustomerSearchVendor";
		
	}
	
	@GetMapping("/serviceBooking")

	public String showServiceBooking(ModelMap modelmap)
	{
		return "CustomerServiceBooking";
	}
	
	@PostMapping("/serviceBooking")

	public String bookRegistration(ModelMap modelmap,@RequestParam Map<String,String> allParams)
	{  
		String id = allParams.get("id");
		System.out.println("ID"+id);
		System.out.println(allParams);
		
		String vendorID = allParams.get("vendorId"+id);
		String serviceType = allParams.get("servType"+id);
		String vendorName = allParams.get("venName"+id);
		String FormtoDate = allParams.get("fromDate"+id);
		String FormfromDate = allParams.get("toDate"+id);
		String city = allParams.get("city"+id);
		LocalDate toDate = LocalDate.parse(FormtoDate);
		LocalDate  fromDate= LocalDate.parse(FormfromDate);
		
		System.out.println(vendorID + serviceType + vendorName + toDate + fromDate + city );
		VendorServiceRegistration bookVendor = new VendorServiceRegistration(0, vendorID, vendorName, city, serviceType,
				toDate, fromDate, "Pending");
		bookVendor = vendorRegistrationService.addBookVendor(bookVendor);
		modelmap.put("bookVendor", bookVendor)	;
		System.out.println(bookVendor);
		return "CustomerBookingDetails";
	}
	
	@GetMapping("myOrders")
    public String custmoreOrders(ModelMap modelmap){
		ArrayList<VendorServiceRegistration> bookedVendors;
		
		
		bookedVendors = vendorRegistrationService.retriveBookedVendor();
		modelmap.put("bookVendors", bookedVendors)	;
		System.out.println("BookedVendors"+bookedVendors);
		if(bookedVendors.size() ==0)
		{
			modelmap.put("errorMessage", "No service requested");	
		}
			
		return "CustomerOrders";
	}
}
