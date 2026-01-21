package com.zepto.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.user.entities.UserEntity;
import com.zepto.user.model.UserDTO;
import com.zepto.user.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public String  doRegister(@RequestBody UserDTO userDTO) {
		
		System.out.println("RegistrationController.doRegister()---------register");
		int response=userService.createUser(userDTO);
		
		
		return  "User Registered Successfully  !!!!";
		
	}
	
	@GetMapping("/login")
	public String dologin(@RequestBody UserEntity userEntity) {
		System.out.println("RegistrationController.dologin()----------login ");
		return userService.loginService(userEntity);
	}
	
	
	
}
