package com.service.admilogin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import io.swagger.annotations.ApiModelProperty;
@Document(collection = "adminDetails")
public class Admin {
	@Id
	@ApiModelProperty(value = "Admin's emailId used as main ID")
	private String emailId;
	@ApiModelProperty(value = "admin's name")
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
	public Admin(String emailId, String name, String address, String mobileNumber, String password) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [emailId=" + emailId + ", name=" + name + ", address=" + address + ", mobileNumber="
				+ mobileNumber + ", password=" + password + "]";
	}
	
	
}
