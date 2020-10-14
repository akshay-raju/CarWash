package com.customerwashrequest.pojo;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;

public class OrderDetails {
	
	@Id
	
	private String orderId;
	private String orderStatus;
	private String orderPackageName;
	private String orderPackageDescription;
	private double orderPackagePrice;
	
	private String date;
	private String time;
	private String location;
	
	
	private String carModel;
	private String carNumber;
	
	private String customerId;
	private String customerName;
	private String customerPhoneNumber;
	
	private String washerId;
	private String washerName;
	private String washerPhoneNumber;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderPackageName() {
		return orderPackageName;
	}
	public void setOrderPackageName(String orderPackageName) {
		this.orderPackageName = orderPackageName;
	}
	public String getOrderPackageDescription() {
		return orderPackageDescription;
	}
	public void setOrderPackageDescription(String orderPackageDescription) {
		this.orderPackageDescription = orderPackageDescription;
	}
	public double getOrderPackagePrice() {
		return orderPackagePrice;
	}
	public void setOrderPackagePrice(double orderPackagePrice) {
		this.orderPackagePrice = orderPackagePrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getWasherId() {
		return washerId;
	}
	public void setWasherId(String washerId) {
		this.washerId = washerId;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public String getWasherPhoneNumber() {
		return washerPhoneNumber;
	}
	public void setWasherPhoneNumber(String washerPhoneNumber) {
		this.washerPhoneNumber = washerPhoneNumber;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderPackageName="
				+ orderPackageName + ", orderPackageDescription=" + orderPackageDescription + ", orderPackagePrice="
				+ orderPackagePrice + ", date=" + date + ", time=" + time + ", location=" + location + ", carModel="
				+ carModel + ", carNumber=" + carNumber + ", customerId=" + customerId + ", customerName="
				+ customerName + ", customerPhoneNumber=" + customerPhoneNumber + ", washerId=" + washerId
				+ ", washerName=" + washerName + ", washerPhoneNumber=" + washerPhoneNumber + "]";
	}
	
	
	

}
