package com.order.washorder.model;

import org.springframework.data.annotation.Id;

public class WashOrder {
	@Id
	private String orderId;
	private String orderStatus;
	private String packageId;
	
	private String date;
	private String time;
	private String location;
	
	
	private String carModel;
	private String carNumber;
	
	private String customerId;
	
	private String washerId;
	private boolean paymentStatus;

	private String paymentId;

	private int rating;

	private String comments;

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

	public String getPackageId() {
		return packageId;
	}

	public void setPakcageId(String pakcageId) {
		this.packageId = pakcageId;
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

	public String getWasherId() {
		return washerId;
	}

	public void setWasherId(String washerId) {
		this.washerId = washerId;
	}
	

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	@Override
	public String toString() {
		return "WashOrder [orderId=" + orderId + ", orderStatus=" + orderStatus + ", packageId=" + packageId + ", date="
				+ date + ", time=" + time + ", location=" + location + ", carModel=" + carModel + ", carNumber="
				+ carNumber + ", customerId=" + customerId + ", washerId=" + washerId + "]";
	}

	public WashOrder(String orderId, String orderStatus, String packageId, String date, String time, String location,
			String carModel, String carNumber, String customerId, String washerId) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.packageId = packageId;
		this.date = date;
		this.time = time;
		this.location = location;
		this.carModel = carModel;
		this.carNumber = carNumber;
		this.customerId = customerId;
		this.washerId = washerId;
	}

	public WashOrder() {
		super();
	}
	
}
