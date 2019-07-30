package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Product Entity Class
@Entity
@Table(name = "Product") // Name of the table in Database
public class Product {

	@Id
	private int productId;// Acts as primary key for the table Product
	@Column(name = "name", length = 20) // name and length of Product Name
	private String productName;
	@Column(name = "model", length = 20)
	private String productModel;
	@Column(name = "price")
	private double price;

	// Default Constructor
	public Product() {
		// TODO Auto-generated constructor stub
	}

	// Parameterized Constructor
	public Product(int productId, String productName, String productModel, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productModel = productModel;
		this.price = price;
	}

	// Getters and Setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
