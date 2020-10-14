package com.example.customerauth.pojo;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "Customer Details")
public class Customer {
	@Id
	@ApiModelProperty(value = "Customer's emailId is the main ID")
	private String emailId;
	@ApiModelProperty(value = "Customer's name")
	private String name;
	private String address;
	private String mobileNumber;
	private String password;

	private ArrayList<Car> cars = new ArrayList<Car>();
	private ArrayList<Card> cards = new ArrayList<Card>();

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

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	

	public Customer(String emailId, String name, String address, String mobileNumber, String password) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [emailId=" + emailId + ", name=" + name + ", address=" + address + ", mobileNumber="
				+ mobileNumber + ", password=" + password + "]";
	}

}
