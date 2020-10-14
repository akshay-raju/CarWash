package com.washer.washerauth.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.washer.washerauth.pojo.Washer;
import com.washer.washerauth.service.WasherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api(value = "Washer service",description = "All washer related Services")
public class Washerapi {

	@Autowired
	private WasherService washerService;

	@PostMapping("/login")
	@ApiOperation(value = "Washer's login")
	public Washer washerLogin(@RequestBody Washer washer) {
		return washerService.login(washer);

	}

	@PostMapping("/signup")
	@ApiOperation(value = "Washer's signup")
	public Washer washerSignUp(@RequestBody Washer washer) {
		return washerService.signup(washer);

	}

	@PostMapping("/updateprofile")
	@ApiOperation(value = "Washer's profile update")
	public Washer updateProfile(@RequestBody Washer washer) {
		return washerService.updateProfile(washer);
	}

	@GetMapping("/getallwashers")
	@ApiOperation(value = "Admin gets all washer's details")
	public List<Washer> getAllWashers() {
		return washerService.getAllWashers();
	}

	@PostMapping("/deletewasher")
	@ApiOperation(value = "Admin deleting washer")
	public Washer deleteWasher(@RequestBody Washer washer) {
		return washerService.deleteWasher(washer);
	}

}
