package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.daos.ProductDAO;
import com.cg.entities.Product;

//Product Service Implementation Class
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO dao;

	// find product usinf productId
	@Transactional(readOnly = true)
	public Product findById(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> product = dao.findById(productId);
		if (product.isPresent()) {
			return product.get();
		} else
			throw new RuntimeException("Product not found!");
	}

	// get product list
	@Transactional(readOnly = true)
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	// delete product from database
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		if (dao.existsById(productId)) {
			dao.deleteById(productId);
		} else {
			throw new RuntimeException("Product not found!");
		}

	}

	// update product in database
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		Optional<Product> temp = dao.findById(p.getProductId());
		if (temp.isPresent()) {
			Product q = temp.get();
			q.setProductName(p.getProductName());
			q.setProductModel(p.getProductModel());
			q.setPrice(p.getPrice());
		} else {
			throw new RuntimeException("Product not found!");
		}
	}

	// create new product and save it in database
	@Transactional(propagation = Propagation.REQUIRED)
	public void createProduct(Product p) {
		// TODO Auto-generated method stub
		if (dao.existsById(p.getProductId())) {
			throw new RuntimeException("Product Already exists!!");
		}
		dao.save(p);

	}

}
