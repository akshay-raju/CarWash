package com.service.admilogin.model;

import org.springframework.data.annotation.Id;

public class WashPackage {
	@Id
	private String packageID;
	private String packageName;
	private String packageDescription;
	private double packageCost;
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
	@Override
	public String toString() {
		return "Package [packageID=" + packageID + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageCost=" + packageCost + "]";
	}
	
	

}
