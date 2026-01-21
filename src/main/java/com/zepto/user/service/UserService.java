package com.zepto.user.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.user.dao.UserDAO;
import com.zepto.user.entities.UserEntity;
import com.zepto.user.model.UserDTO;

@Service
public class UserService {
	@Autowired
	UserDAO userDAO;
	
	public int createUser(UserDTO userDTO) {
		UserEntity userEntity= new UserEntity();
		userEntity.setName(userDTO.getName());
		userEntity.setEmail(userDTO.getEmail());
		
		
		
		// AUTO-GENERATED PASSWORD (simple)
        String autoPassword = UUID.randomUUID().toString().substring(0, 8);
        userEntity.setPassword(autoPassword);

       Integer response= userDAO.saveUser(userEntity);
        System.out.println("Auto Generated Password = " + autoPassword);
		
        return response;
	}
	
	public String loginService(UserEntity userEntity) {
		UserEntity entity=userDAO.loginDAO(userEntity);
		if (entity!=null) {
			return "Login Successful";
        } else {
            return "Invalid Email or Password";
	    }
	}
}
