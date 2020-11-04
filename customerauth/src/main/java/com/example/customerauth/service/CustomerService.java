package com.example.customerauth.service;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.customerauth.pojo.Car;
import com.example.customerauth.pojo.Customer;
import com.example.customerauth.repo.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;

	public Customer signup(Customer customer) {
		Optional<Customer> findExisted = customerRepo.findById(customer.getEmailId());
		if (findExisted.isPresent()) {
			return null;
		} else {
			System.out.println("in else");
			try {
				System.out.println("in try block");
				MessageDigest md =MessageDigest.getInstance("SHA");
				md.update(customer.getPassword().getBytes());
				byte[] s =md.digest();
				StringBuilder sb= new StringBuilder();
				for(byte b:s)
				{
					sb.append(String.format("%02x", b));
				}
				customer.setPassword(sb.toString());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
//			 catch (NoSuchAlgorithmException e) {​​​​​​
//
//	             // TODO Auto-generated catch block
//
//	             e.printStackTrace();
//
//	         }​​​​​​
			
			return customerRepo.save(customer);
		}

	}

	public Customer login(Customer customer) {
		Optional<Customer> findExisted = customerRepo.findById(customer.getEmailId());
		try {
			System.out.println("in try block");
			MessageDigest md =MessageDigest.getInstance("SHA");
			md.update(customer.getPassword().getBytes());
			byte[] s =md.digest();
			StringBuilder sb= new StringBuilder();
			for(byte b:s)
			{
				sb.append(String.format("%02x", b));
			}
			customer.setPassword(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if (findExisted.isPresent()) {
			Customer temp = findExisted.get();
			if (temp.getPassword().contentEquals(customer.getPassword())) {
				return temp;
			}

		}
		return null;
	}

	public Customer addfiledetails(Car c, MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		c.setImagename(fileName);
		c.setImage(file.getBytes());

		Optional<Customer> customer = customerRepo.findById(c.getCustomerId());
		if (customer.isPresent()) {
			Customer temp = customer.get();
			ArrayList<Car> allCars = temp.getCars();
			allCars.add(c);
			temp.setCars(allCars);
			return customerRepo.save(temp);

		}

		return null;

	}

	public Customer deleteCar(Car car) {
		Optional<Customer> cus = customerRepo.findById(car.getCustomerId());
		if (cus.isPresent()) {
			Customer temp = cus.get();
			ArrayList<Car> customerAllCars = temp.getCars();
			ArrayList<Car> remainedList = new ArrayList<Car>(customerAllCars);
			for (Car x : customerAllCars) {
				if (x.getCarNumber().contentEquals(car.getCarNumber())
						&& x.getCarModel().contentEquals(car.getCarModel())) {
					remainedList.remove(x);
				}
			}
			temp.setCars(remainedList);
			return customerRepo.save(temp);
		}
		return null;
	}

	public Customer editProfile(Customer customer) {
		Optional<Customer> temp = customerRepo.findById(customer.getEmailId());
		if (temp.isPresent()) {
			Customer exist = temp.get();
			exist.setAddress(customer.getAddress());
			exist.setMobileNumber(customer.getMobileNumber());
			exist.setName(customer.getName());
			exist.setPassword(customer.getPassword());

			return customerRepo.save(exist);
		}
		return null;
	}

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	public Customer deleteCustomer(Customer customer) {
		Optional<Customer> temp = customerRepo.findById(customer.getEmailId());
		if (temp.isPresent()) {
			Customer exists = temp.get();
			customerRepo.delete(exists);
			return exists;
		}
		return null;
	}
}
