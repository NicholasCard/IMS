package com.revature.imsApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product", schema = "ims")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
    private Integer productId;

	@Column(name="title")
	private String title;
	
	@Column(name="category")
	private String category;

	@Column(name="man")
	private String man;
	
	@Column(name="min_limit")
	private int minLimit;
	
	@Column(name="product_quantity")
	private int productQuantity;
	
	public Product() {
		super();
	}
	
	public Product(String title, String category, String man, int minLimit, int productQuantity) {
		this.title = title;
		this.category = category;
		this.man = man;
		this.minLimit = minLimit;
		this.productQuantity = productQuantity;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMan() {
		return man;
	}

	public void setMan(String man) {
		this.man = man;
	}

	public int getMinLimit() {
		return minLimit;
	}

	public void setMinLimit(int minLimit) {
		this.minLimit = minLimit;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}









