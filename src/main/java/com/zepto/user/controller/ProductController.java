package com.zepto.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.user.dao.ProductDAO;
import com.zepto.user.entities.ProductEntity;
import com.zepto.user.entities.UserEntity;
import com.zepto.user.model.ProductDTO;
import com.zepto.user.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("/create-product")
	public String createProductController(@RequestBody ProductDTO productDTO) {
     
		int response = productService.createProduct(productDTO);
		return "product Created: ";
	}
	
	@GetMapping("/search/{name}")
	public String  search(@PathVariable("name") String name){	

      List<ProductEntity> list=productService.searchAllProductByName(name);
		return "sir data mil gya lekin aap pehle payment karo" ;
		
	}
}
