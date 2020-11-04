package com.washer.washerauth.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.washerauth.pojo.Washer;
import com.washer.washerauth.repo.WasherRepo;

@Service
public class WasherService {

	@Autowired
	private WasherRepo washerRepo;

	public Washer signup(Washer washer) {
		Optional<Washer> findExisted = washerRepo.findById(washer.getEmailId());
		if (findExisted.isPresent()) {
			return null;
		} else {
			System.out.println("in else");
			try {
				System.out.println("in try block");
				MessageDigest md =MessageDigest.getInstance("SHA");
				md.update(washer.getPassword().getBytes());
				byte[] s =md.digest();
				StringBuilder sb= new StringBuilder();
				for(byte b:s)
				{
					sb.append(String.format("%02x", b));
				}
				washer.setPassword(sb.toString());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
//			 catch (NoSuchAlgorithmException e) {​​​​​​
//
//	             // TODO Auto-generated catch block
//
//	             e.printStackTrace();
//
//	         }
			return washerRepo.save(washer);
		}

	}

	public Washer login(Washer washer) {
		Optional<Washer> findExisted = washerRepo.findById(washer.getEmailId());
		try {
			System.out.println("in try block");
			MessageDigest md =MessageDigest.getInstance("SHA");
			md.update(washer.getPassword().getBytes());
			byte[] s =md.digest();
			StringBuilder sb= new StringBuilder();
			for(byte b:s)
			{
				sb.append(String.format("%02x", b));
			}
			washer.setPassword(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if (findExisted.isPresent()) {
			Washer temp = findExisted.get();
			if (temp.getPassword().contentEquals(washer.getPassword())) {
				return temp;
			}

		}
		return null;
	}

	public Washer updateProfile(Washer washer) {
		Optional<Washer> temp = washerRepo.findById(washer.getEmailId());
		if (temp.isPresent()) {
			Washer exists = temp.get();
			exists.setAddress(washer.getAddress());
			exists.setName(washer.getName());
			exists.setPhoneNumber(washer.getPhoneNumber());
			exists.setPassword(washer.getPassword());
			return washerRepo.save(exists);

		}
		return null;
	}

	public List<Washer> getAllWashers() {
		return washerRepo.findAll();
	}

	public Washer deleteWasher(Washer washer) {
		Optional<Washer> temp = washerRepo.findById(washer.getEmailId());
		if (temp.isPresent()) {
			Washer exists = temp.get();
			washerRepo.delete(exists);
			return exists;

		}
		return null;
	}
}
