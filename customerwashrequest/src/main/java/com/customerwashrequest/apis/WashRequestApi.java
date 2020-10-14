package com.customerwashrequest.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerwashrequest.pojo.WashOrder;
import com.customerwashrequest.service.WashOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api(value = "washRequest Controller",description = "All washRequest related services")
public class WashRequestApi {

	@Autowired
	private WashOrderService service;

	@PostMapping("/saveorder")
	@ApiOperation(value = "Saving order")
	public WashOrder saveOrder(@RequestBody WashOrder order) {
		System.out.println(order);
		return service.saveOrder(order);
	}

	@PostMapping("/acceptorder")
	@ApiOperation(value = "Washer accepting the order")
	public WashOrder acceptingOrder(@RequestBody WashOrder order) {
		System.out.println("in controller");
		System.out.println(order);

		return service.acceptingOrder(order);
	}

	@PostMapping("/orderserved")
	@ApiOperation(value = "order that is served")
	public WashOrder orderServed(@RequestBody WashOrder order) {
		return service.orderServed(order);

	}

	@PostMapping("/savingfeedback")
	@ApiOperation(value = "Saving feedback of the served washRequest")
	public WashOrder savingFeedback(@RequestBody WashOrder order) {
		return service.savingfeedback(order);
	}

}
