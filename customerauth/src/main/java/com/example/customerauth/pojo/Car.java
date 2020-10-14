package com.example.customerauth.pojo;

import java.util.Arrays;

public class Car {
	private String customerId;
	private String carBrandName;
	private String carModel;
	private String carNumber;

	private String imagename;
	private byte[] image;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getCarBrandName() {
		return carBrandName;
	}

	public void setCarBrandName(String carBrandName) {
		this.carBrandName = carBrandName;
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

	@Override
	public String toString() {
		return "Car [customerId=" + customerId + ", carBrandName=" + carBrandName + ", carModel=" + carModel
				+ ", carNumber=" + carNumber + ", imagename=" + imagename + ", image=" + Arrays.toString(image) + "]";
	}
}
