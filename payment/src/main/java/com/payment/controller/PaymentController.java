package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.Payment;
import com.payment.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "*")
@RestController
@Api(value = "Payment service",description = "All payment services")
public class PaymentController {
	@Autowired
	public PaymentService service;
	
	@PostMapping("/savepaymentdetails")
	@ApiOperation(value = "Save Payment Details")
	public Payment savePaymentDetails(@RequestBody Payment payment) {
		System.out.println("in payment controller");
		return service.savePaymentDetails(payment);
	}

}
