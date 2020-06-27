package com.wipro.asg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.wipro.asg.model.Vendor;
import com.wipro.asg.service.VendorRegitrationService;

@SpringBootApplication
public class OnlineServiceRequestApplication implements CommandLineRunner{
	
	@Autowired
	private VendorRegitrationService vendorRegistration;

	public static void main(String[] args) {
		SpringApplication.run(OnlineServiceRequestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 List<String> list = Stream.of("Painter","Plumber")
			      .collect(Collectors.toList());
		
		System.out.println(list);
		
	//	Vendor vendor = new Vendor("satish","Satish12345","123456789","DelhiRKPuram","Delhi",list);
	
	//	System.out.println(vendor);
		
		//	List<String> serviceType = (List<String>) Arrays.asList("Painter","Plumber");
		
		vendorRegistration.addRegistration(new Vendor("satish","Satish12345","123456789","DelhiRKPuram","Delhi",list));
	
		vendorRegistration.addRegistration(new Vendor("kumkum","kmkm12345","123456789","DelhiRKPuram","Delhi",list));
		 System.out.println(vendorRegistration.retriveVenfor());

	}

}
