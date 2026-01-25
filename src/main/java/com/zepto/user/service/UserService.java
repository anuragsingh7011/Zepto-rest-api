package com.zepto.user.service;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.user.dao.UserDAO;
import com.zepto.user.entities.UserEntity;
import com.zepto.user.exception.InvalidLoginException;
import com.zepto.user.exception.UserAlreadyExistException;
import com.zepto.user.model.UserDTO;

@Service
public class UserService {
	@Autowired
	UserDAO userDAO;
	
	public int createUser(UserDTO userDTO) {
		UserEntity emailExist	=userDAO.findByEmail(userDTO.getEmail());
			if(emailExist!=null) {
				throw new UserAlreadyExistException("user already exist with email: "+ userDTO.getEmail());
			}
		UserEntity userEntity= new UserEntity();
		userEntity.setName(userDTO.getName());
		userEntity.setEmail(userDTO.getEmail());

		// AUTO-GENERATED PASSWORD (simple)
        String autoPassword = UUID.randomUUID().toString().substring(0, 8);
        userEntity.setPassword(autoPassword);

        System.out.println("Auto Generated Password = " + autoPassword);
		
        return  userDAO.saveUser(userEntity);
        
	}
	
	public String loginService(UserEntity userEntity) {
		
		UserEntity entity=userDAO.loginDAO(userEntity);
		if (entity==null) {
			throw new InvalidLoginException("Invalid Email or Password");
		}
		return "Login Successful";
	}
}
