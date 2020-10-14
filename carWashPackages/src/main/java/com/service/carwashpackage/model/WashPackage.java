package com.service.carwashpackage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "washPackage")
public class WashPackage {
	@Id
	@ApiModelProperty(value = "ID of the package")
	private String packageID;
	@ApiModelProperty(value = "Name of the package")
	private String packageName;
	@ApiModelProperty(value = "Description of the package")
	private String packageDescription;
	@ApiModelProperty(value = "Cost of the package")
	private double packageCost;

	public WashPackage(String packageID, String packageName, String packageDescription, double packageCost) {
		super();
		this.packageID = packageID;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageCost = packageCost;
	}

	public String getPackageID() {
		return packageID;
	}

	public void setPackageID(String packageID) {
		this.packageID = packageID;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	public WashPackage() {
		super();
	}

	@Override
	public String toString() {
		return "WashPackage [packageID=" + packageID + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageCost=" + packageCost + "]";
	}

}
