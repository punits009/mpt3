package com.cg.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Product;
import com.cg.services.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	// Adding Dummy Data Into The Database
	@PostConstruct
	public String createSample() {
		Product p1 = new Product(101, "Windows ", "10 PRO", 8000D);
		Product p2 = new Product(102, "Ubuntu ", "18.04 Desktop", 7000D);
		Product p3 = new Product(103, "Linux ", "Mint 19", 7500D);
		service.createProduct(p1);
		service.createProduct(p2);
		service.createProduct(p3);
		return "Three products created!";
	}

	@GetMapping("/products") // Get mapping for getting list of products
	public List<Product> getAll() {
		return service.getAll();
	}

	@GetMapping(value = "/products-{productId}") // to find product using productId
	public Product findbyId(@PathVariable int productId) {
		return service.findById(productId);
	}

	@PostMapping(value = "/new", consumes = { "application/json" }) // to add product into the database
	public String save(@RequestBody Product p) {
		service.createProduct(p);
		return "Product added!";
	}

	@PutMapping(value = "/update", consumes = { "application/json" }) // to make an update into the database using
																		// Product json
	public String update(@RequestBody Product p) {
		service.updateProduct(p);
		return "product updated";
	}

	@DeleteMapping(value = "/delete{productId}") // to delete product from database using productId
	public String deleteUser(@PathVariable int productId) {
		service.deleteProduct(productId);
		return "product deleted";
	}

}
