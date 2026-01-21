package com.zepto.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zepto.user.entities.UserEntity;


@Repository
public class UserDAO {
	@Autowired	
	SessionFactory sessionFactory;
	
	
	public Integer saveUser(UserEntity userEntity) {
		Session session=sessionFactory.openSession();
		  Transaction tnx =session.beginTransaction(); 
		 Integer response=(Integer) session.save(userEntity);
		  tnx.commit();
		  session.close();
		  return response;
		  
	}
	
	public UserEntity loginDAO(UserEntity userEntity) {
		Session session=sessionFactory.openSession();
		UserEntity userEntity2=session.createQuery("from UserEntity where email =: email and password =: password" , UserEntity.class)
		.setParameter("email", userEntity.getEmail())
        .setParameter("password", userEntity.getPassword())
        .uniqueResult();
		
		return userEntity2;
		
		
	}
	
	
}
