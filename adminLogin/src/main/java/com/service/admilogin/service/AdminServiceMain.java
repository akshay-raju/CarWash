package com.service.admilogin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.admilogin.model.Admin;
import com.service.admilogin.repo.AdminRepo;

@Service
public class AdminServiceMain {
 @Autowired
 private AdminRepo adminRepo;
 
 public Admin adminLogin(Admin admin) {
		Optional<Admin> existedUser = adminRepo.findById(admin.getEmailId());
		if(existedUser.isPresent())
		{
			Admin temp=existedUser.get();
			if(temp.getPassword().contentEquals(admin.getPassword()))
			{
				return temp;
			}
		}
		return null;
		
		
	}
	
	public Admin signup(Admin admin) {
		
		return adminRepo.save(admin);
		
		
		
	}
}
