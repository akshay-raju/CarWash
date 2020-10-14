package com.service.carwashpackage.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.carwashpackage.model.WashPackage;
import com.service.carwashpackage.service.WashPackageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "*")
@RestController
@Api(value="carwashpackage controller",description = "All carWash Package related services")
public class WashPackageController {
	
	@Autowired
	private WashPackageService packageService;
	
	@GetMapping("/allPackages")
	@ApiOperation(value = "All carWash Packages")
	public List<WashPackage> getAllPackages(){
		return packageService.getAllPackages();
	}
	
	@PostMapping("/savePackage")
	@ApiOperation(value = "Save carWash Package")
	public WashPackage savePackage(@RequestBody WashPackage pack) {
		System.out.println("Package successfully changed");
		return packageService.savePackage(pack);
	}
	
	@PostMapping("/deletePackage")
	@ApiOperation(value = "Admin delete's carWash Package")
	public boolean deletePackage(@RequestBody WashPackage pack) {
		return packageService.deletePackage(pack);
	}

}
