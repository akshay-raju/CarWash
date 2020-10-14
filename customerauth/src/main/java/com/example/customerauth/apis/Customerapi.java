package com.example.customerauth.apis;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.customerauth.pojo.Car;
import com.example.customerauth.pojo.Customer;
import com.example.customerauth.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api(value = "Customer Service",description = "All customer related services")
public class Customerapi {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/signup")
	@ApiOperation(value = "Customer Signup")
	public Customer signup(@RequestBody Customer customer) {
		return customerService.signup(customer);

	}

	@PostMapping("/login")
	@ApiOperation(value = "Customer Login")
	public Customer login(@RequestBody Customer customer) {
		return customerService.login(customer);

	}

	@PostMapping("/addingcardetails")
	@ApiOperation(value = "Customer adding his car details")
	public Customer addfiledetails(@RequestParam("car") String car, @RequestParam("file") MultipartFile file)
			throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Car c = objectMapper.readValue(car, Car.class);
		System.out.println(c);
		return customerService.addfiledetails(c, file);
	}

	@PostMapping("/deletecar")
	@ApiOperation(value = "Customer deleting car")
	public Customer deleteCar(@RequestBody Car car) {
		System.out.println("in controller");
		System.out.println(car);
		return customerService.deleteCar(car);

	}

	@PostMapping("/updateprofile")
	@ApiOperation(value = "Customer profile update")
	public Customer updateProfile(@RequestBody Customer customer) {
		return customerService.editProfile(customer);
	}

	@GetMapping("/getallcustomers")
	@ApiOperation(value = "Admin getting All Customer's")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@PostMapping("/deletecustomer")
	@ApiOperation(value = "Admin deleting Customer")
	public Customer deleteCustomer(@RequestBody Customer customer) {
		return customerService.deleteCustomer(customer);
	}
}
