package com.service.admilogin.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		try {
			System.out.println("in try block");
			MessageDigest md =MessageDigest.getInstance("SHA");
			md.update(admin.getPassword().getBytes());
			byte[] s =md.digest();
			StringBuilder sb= new StringBuilder();
			for(byte b:s)
			{
				sb.append(String.format("%02x", b));
			}
			admin.setPassword(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
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
		Optional<Admin> findExisted = adminRepo.findById(admin.getEmailId());
		if (findExisted.isPresent()) {
			return null;
		} else {
			System.out.println("in else");
			try {
				System.out.println("in try block");
				MessageDigest md =MessageDigest.getInstance("SHA");
				md.update(admin.getPassword().getBytes());
				byte[] s =md.digest();
				StringBuilder sb= new StringBuilder();
				for(byte b:s)
				{
					sb.append(String.format("%02x", b));
				}
				admin.setPassword(sb.toString());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		return adminRepo.save(admin);
		
		
		}
	}
}
