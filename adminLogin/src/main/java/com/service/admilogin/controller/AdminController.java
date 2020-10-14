package com.service.admilogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.admilogin.model.Admin;
import com.service.admilogin.service.AdminServiceMain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api(value = "Admin Service",description = "Admin's related services")
public class AdminController {

	@Autowired
	private AdminServiceMain adminService;
	
	@PostMapping("/login")
	@ApiOperation(value = "admin's login")
	public Admin login(@RequestBody Admin admin) {
		return adminService.adminLogin(admin);
		
	}
	
	
	@PostMapping("/signup")
	@ApiOperation(value = "admin's signup")
	public Admin signUp(@RequestBody Admin admin)
	{
		return adminService.signup(admin);
		
		
	}

}
