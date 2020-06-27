package com.wipro.asg.service;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Service;

import com.wipro.asg.enums.Status;
import com.wipro.asg.model.Vendor;
import com.wipro.asg.model.VendorServiceRegistration;

@Service
public class VendorRegitrationService {
	
	private ArrayList<Vendor> vendors = new ArrayList<Vendor>();
	private ArrayList<VendorServiceRegistration> bookedVendords = new ArrayList<>();
	private int requestid = 1004;
//	bookedVendords.add(new ());
	
	
	public VendorServiceRegistration addBookVendor(VendorServiceRegistration bookVendor) {
		bookVendor.setRequestId(requestid);
		bookVendor.setStatus(Status.PENDING.toString());
		bookedVendords.add(bookVendor);
		requestid++;
		return bookVendor;
		
	}
	
	public ArrayList<VendorServiceRegistration> retriveBookedVendor(){
		return bookedVendords;
	}
	
	public void addRegistration(Vendor vendor)
	{
		
		
		vendors.add(vendor);
	}
	
	public ArrayList<Vendor> retriveVenfor()
	{
		return vendors;
		
	}
	
	public boolean SearchVendor(String city,String serviceType) {
		
		ArrayList<Vendor> vendors;
		ArrayList<Vendor> searchedVendors;
		
		vendors = retriveVenfor();
		
		searchedVendors=(ArrayList<Vendor>) vendors.stream().filter(vendor -> vendor.getCity().equals(city) && vendor.getServiceType().contains(serviceType)).collect(Collectors.toList());
		
		for (Vendor vendor2 : searchedVendors) {
			System.out.println(vendor2);
			
		}
		
		return false;
	}

}
