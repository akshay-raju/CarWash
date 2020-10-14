package com.service.carwashpackage.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.carwashpackage.model.WashPackage;
import com.service.carwashpackage.repo.WashPackageRepo;

@Service
public class WashPackageService {
	@Autowired
	private WashPackageRepo packageRepo;
	
	public List<WashPackage> getAllPackages(){
		return packageRepo.findAll();
	}
	
	public WashPackage savePackage(WashPackage pack) {
		return packageRepo.save(pack);
	}
	
	public boolean deletePackage(WashPackage pack) {
		Optional<WashPackage> existed=packageRepo.findById(pack.getPackageID());
		if(existed.isPresent()) {
			packageRepo.deleteById(pack.getPackageID());
			return true;
		}
		return false;
		
	}
}
