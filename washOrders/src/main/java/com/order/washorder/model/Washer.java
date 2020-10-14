package com.order.washorder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Washer Details")
public class Washer {
	@Id
	private String emailId;
	private String name;
	private String phoneNumber;
	private String address;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Washer [emailId=" + emailId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ "]";
	}
	public Washer(String emailId, String name, String phoneNumber, String address) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public Washer() {
		super();
	}
	
}
