package com.wipro.asg.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
//import java.util.Date;
@Component
public class VendorServiceRegistration {
	
  private String customerId;
  private int requestId ;
  private String vendorId;
  private String vendorName;
  private String city;
  private String serviceType;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private LocalDate toDate;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private LocalDate fromDate;
  private String status;
  
 

public VendorServiceRegistration() {
	  
  }

public VendorServiceRegistration(String vendorId, String vendorName, String serviceType,String city) {
	super();
	this.vendorId = vendorId;
	this.vendorName = vendorName;
	this.serviceType = serviceType;
	this.city = city;
}





public VendorServiceRegistration(int requestId, String vendorId, String vendorName, String city, String serviceType,
		LocalDate toDate, LocalDate fromDate, String status) {
	super();
	this.requestId = requestId;
	this.vendorId = vendorId;
	this.vendorName = vendorName;
	this.city = city;
	this.serviceType = serviceType;
	this.toDate = toDate;
	this.fromDate = fromDate;
	this.status = status;
}

public String getCustomerId() {
	return customerId;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

public int getRequestId() {
	return requestId;
}

public void setRequestId(int requestId) {
	this.requestId = requestId;
}

public LocalDate getToDate() {
	return toDate;
}

public void setToDate(LocalDate toDate) {
	this.toDate = toDate;
}

public LocalDate getFromDate() {
	return fromDate;
}

public void setFromDate(LocalDate fromDate) {
	this.fromDate = fromDate;
}

public String getVendorId() {
	return vendorId;
}

public String getVendorName() {
	return vendorName;
}

public String getServiceType() {
	return serviceType;
}

public void setVendorId(String vendorId) {
	this.vendorId = vendorId;
}

public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}

public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

@Override
public String toString() {
	return "VendorServiceRegistration [requestId=" + requestId + ", vendorId=" + vendorId + ", vendorName=" + vendorName
			+ ", city=" + city + ", serviceType=" + serviceType + ", toDate=" + toDate + ", fromDate=" + fromDate
			+ ", status=" + status + "]";
}


  





  
  

}
