package com.zepto.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.user.model.ProductDTO;
import com.zepto.user.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("/create-product")
	public String createProductController(@RequestBody ProductDTO productDTO) {
     
		int response = productService.createProduct(productDTO);
		return "product Created prod_id: "+ response;
	}
	
	@GetMapping("/search/{name}")
	public Object search(@PathVariable("name") String name){

	    return   productService.searchAllProductByName(name);
	   
	}
}
