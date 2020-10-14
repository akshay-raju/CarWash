package com.example.customerauth;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.customerauth.pojo.Customer;
import com.example.customerauth.repo.CustomerRepo;
import com.example.customerauth.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerauthApplicationTests {
	@Autowired
	private CustomerService service;
	@MockBean
	private CustomerRepo repo;
		
	@SuppressWarnings("deprecation")
	@Test
	public void getAllCustomerTest() {
		when(repo.findAll()).thenReturn(Stream.of(new Customer("akshay@gmail.com","akshay","jayanagar","9090909090","password"), new Customer("ajay@gmail.com","ajay","jp nagar","9090909099","password2")).collect(Collectors.toList()));
		assertEquals(2, service.getAllCustomers().size());
	}
	
}
