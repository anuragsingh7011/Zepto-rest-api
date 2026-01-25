package com.zepto.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.user.dao.ProductDAO;
import com.zepto.user.entities.ProductEntity;
import com.zepto.user.model.ProductDTO;

@Service
public class ProductService {
	
	@Autowired
	ProductDAO productDAO;
	
	public int createProduct(ProductDTO productDTO) {
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(productDTO.getName());
		productEntity.setPrice(productDTO.getPrice());
		productEntity.setCategory(productDTO.getCategory());
		productEntity.setDescription(productDTO.getDescription());
		 
		Integer response = productDAO.saveProduct(productEntity);
		
		return response;
	}
	
	public List<ProductEntity> searchAllProductByName(String name){
		  return productDAO.fetchAllProductByName(name);
		
	}
}
