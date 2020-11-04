package com.example.customerauth;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
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
		when(repo.findAll()).thenReturn(Stream
				.of(new Customer("akshay@gmail.com", "akshay", "jayanagar", "9090909090", "password"),
						new Customer("ajay@gmail.com", "ajay", "jp nagar", "9090909099", "password2"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllCustomers().size());
	}

	@Test
	public void deleteCustomerTest() {
		Customer customer = new Customer("k@gmail.com", "ky", "kj", "9888765043",
				"13fbd79c3d390e5d6585a21e11ff5ec1970cff0c");
		assertEquals(customer, service.deleteCustomer(customer));
	}

	@Test
	public void signupCustomerTest() {
		Customer customer = new Customer("aj@gmail.com", "aj", "jayanag", "9888765043",
				"2048b22ac0881f917af3e938105055ab85498548");
		when(repo.save(customer)).thenReturn(customer);
		assertEquals(customer, service.signup(customer));

	}

	@Test
	public void loginTest() {
		Customer customer = new Customer("aj@gmail.com", "aj", "jayanag", "9888765043",
				"2048b22ac0881f917af3e938105055ab85498548");
		when(repo.save(customer)).thenReturn(customer);
		assertEquals(customer, service.login(customer));
	}

}
