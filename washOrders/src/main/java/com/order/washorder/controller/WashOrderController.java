package com.order.washorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.washorder.model.Customer;
import com.order.washorder.model.OrderDetails;
import com.order.washorder.model.Washer;
import com.order.washorder.service.WashOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "*")
@RestController
@Api(value = "WashOrder Controller",description = "All WashOrder services")
public class WashOrderController {
	@Autowired
	private WashOrderService washOrderService;
	
	@GetMapping("/awaitingrequests")
	@ApiOperation(value = "All Customer Requests")
	public List<OrderDetails> getAllCustomerRequests(){
		System.out.println("in controller");
		return washOrderService.getAllCustomerRequests();
	}
	
	@PostMapping("/customerinprogressrequests")
	@ApiOperation(value = "Customer's In Progress Requests")
	public List<OrderDetails> customerInProgressRequests(@RequestBody Customer cus){
		System.out.println("in controller"+ cus.getEmailId());
		return washOrderService.customerInProgressRequests(cus.getEmailId());
	}
	
	@PostMapping("/customeroldrequest")
	@ApiOperation(value = "Customer Requests served")
	public List<OrderDetails> customerOldRequests(@RequestBody Customer cus){
		return washOrderService.customerOldRequests(cus.getEmailId());
		
	}
	
	@PostMapping("/washerInprogress")
	@ApiOperation(value = "Washer's In Progress Requests")
	public List<OrderDetails> washerInProgress(@RequestBody Washer washer){
		System.out.println("in controller      "+washer.getEmailId());
		return washOrderService.washerInprogress(washer.getEmailId());
	}
	
	@PostMapping("/washeroldrequests")
	@ApiOperation(value = "Washer Requests Served")
	public List<OrderDetails> washerOldRequests(@RequestBody Washer washer){
			System.out.println("in controller      "+washer.getEmailId());
		return washOrderService.washerOldRequests(washer.getEmailId());
	}
}
