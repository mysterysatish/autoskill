package com.wipro.asg.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Vendor {
	
	private String name;
	private String id;
	private String password;
	private String address;
	private String city;
	private List<String> serviceType;
	
	public Vendor() {
	super();
	}

	public Vendor(String name, String id, String password, String address, String city, List<String> serviceType) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.address = address;
		this.city = city;
		this.serviceType = serviceType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getServiceType() {
		return serviceType;
	}

	public void setServiceType(List<String> serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public String toString() {
		return "Vendor [name=" + name + ", id=" + id + ", password=" + password + ", address=" + address + ", city="
				+ city + ", serviceType=" + serviceType + "]";
	}

	
	
	
	

}
