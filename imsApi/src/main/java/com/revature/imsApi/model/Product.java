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
    private Integer product_id;

	@Column(name="title")
	private String title;
	
	@Column(name="category")
	private String category;

	@Column(name="man")
	private String man;
	
	@Column(name="min_limit")
	private int min_limit;
	
	public Product() {
		super();
	}
	
	public Product(String title, String category, String man, int min_limit) {
		this.title = title;
		this.category = category;
		this.man = man;
		this.min_limit = min_limit;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
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

	public int getMin_limit() {
		return min_limit;
	}

	public void setMin_limit(int min_limit) {
		this.min_limit = min_limit;
	}
}









