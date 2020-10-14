package com.example.customerauth.pojo;

public class Card {
	private String cardNumber;
	private String cardExpireDate;
	private String nameOnCard;
	private String cardCvv;

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

	public String getCardCvv() {
		return cardCvv;
	}

	public void setCardCvv(String cardCvv) {
		this.cardCvv = cardCvv;
	}

	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", cardExpireDate=" + cardExpireDate + ", nameOnCard=" + nameOnCard
				+ ", cardCvv=" + cardCvv + "]";
	}
}
