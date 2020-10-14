package com.order.washorder.model;

import org.springframework.data.annotation.Id;

public class Payment {
	@Id
	private String paymentId;
	private String orderId;
	private double amount;
	private String cardNumber;
	private String cardExpireDate;
	private String nameOnCard;
	private Integer cardCvv;
	
	
	
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpireDate() {
		return cardExpireDate;
	}
	public void setCardExpireDate(String cardExpireDate) {
		this.cardExpireDate = cardExpireDate;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public Integer getCardCvv() {
		return cardCvv;
	}
	public void setCardCvv(Integer cardCvv) {
		this.cardCvv = cardCvv;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", orderId=" + orderId + ", cardNumber=" + cardNumber
				+ ", cardExpireDate=" + cardExpireDate + ", nameOnCard=" + nameOnCard + ", cardCvv=" + cardCvv + "]";
	}
}
