package com.cg.services;

import java.util.List;

import com.cg.entities.Product;

//Interface for Product related services
public interface ProductService {

	public Product findById(int productId);

	public List<Product> getAll();

	public void deleteProduct(int productId);

	public void updateProduct(Product p);

	public void createProduct(Product p);

}
