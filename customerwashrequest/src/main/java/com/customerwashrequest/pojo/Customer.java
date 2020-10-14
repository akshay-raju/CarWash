package com.customerwashrequest.pojo;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer Details")
public class Customer {
	
	@Id
	private String emailId;
	private String name;
	private String address;
	private String mobileNumber;
	private String password;

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Customer [emailId=" + emailId + ", name=" + name + ", address=" + address + ", mobileNumber="
				+ mobileNumber + ", password=" + password + "]";
	}
	
	

	
	

}
