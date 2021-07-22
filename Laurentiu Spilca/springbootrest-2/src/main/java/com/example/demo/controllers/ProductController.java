package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/add/{name}/{price}")
	public void addProduct(@PathVariable String name, @PathVariable double price) {
		System.out.println(price);
		productService.addProduct(name, price);
	}
}