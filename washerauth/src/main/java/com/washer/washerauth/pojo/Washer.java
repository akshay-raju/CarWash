package com.washer.washerauth.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
@Document(collection = "Washer Details")
public class Washer {
	@Id
	@ApiModelProperty(value = "Washer's emailID is used as the main ID")
	private String emailId;
	@ApiModelProperty(value = "Washer's name")
	private String name;
	private String phoneNumber;
	private String password;
	private String address;
	private String washServiceName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
	}
	public String getWashServiceName() {
		return washServiceName;
	}
	public void setWashServiceName(String washServiceName) {
		this.washServiceName = washServiceName;
	}
	@Override
	public String toString() {
		return "Washer [emailId=" + emailId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", password="
				+ password + ", adress=" + address + ", washServiceName=" + washServiceName + "]";
	}

}
