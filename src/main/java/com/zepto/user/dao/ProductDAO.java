package com.zepto.user.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zepto.user.entities.ProductEntity;



@Repository
public class ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Integer saveProduct(ProductEntity productEntity) {
		
		Session session=sessionFactory.openSession();
		Transaction tnx=session.beginTransaction();
			Integer response=(Integer) session.save(productEntity);
			
			tnx.commit();
			session.close();
			return response;
			
	}
	
	public List<ProductEntity> fetchAllProductByName(String name){
		Session session=sessionFactory.openSession();
		  List<ProductEntity> list=session.createQuery("from ProductEntity where name like :name", ProductEntity.class)
					.setParameter("name", "%"+ name+"%").list();
		  session.close();
		return list;
	}
}
