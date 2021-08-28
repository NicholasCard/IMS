package com.revature.imsApi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_stock", schema = "ims")
public class Stock {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stock_id;
	
	@Column(name="product_id")
	private Integer product_id;
	
	@Column(name="transaction_date")
	private Date transaction_date;

	@Column(name="vendor")
	private String vendor;
	
	@Column(name="batch_code")
	private String batch_code;
	
	@Column(name="invoice_num")
	private String invoice_num;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="transaction_type")
    @Enumerated(EnumType.STRING)
	private StockType transaction_type;
	
	public Stock() {
		super();
	}
	
	public Stock(Integer product_id, Date transaction_date, String vendor, 
			     String batch_code, String invoice_num, int quantity, StockType transaction_type) {
		this.product_id = product_id;
		this.transaction_date = transaction_date;
		this.vendor = vendor;
		this.batch_code = batch_code;
		this.invoice_num = invoice_num;
		this.quantity = quantity;
		this.transaction_type = transaction_type;
	}

	public Integer getStock_id() {
		return stock_id;
	}

	public void setStock_id(Integer stock_id) {
		this.stock_id = stock_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getBatch_code() {
		return batch_code;
	}

	public void setBatch_code(String batch_code) {
		this.batch_code = batch_code;
	}

	public String getInvoice_num() {
		return invoice_num;
	}

	public void setInvoice_num(String invoice_num) {
		this.invoice_num = invoice_num;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public StockType getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(StockType transaction_type) {
		this.transaction_type = transaction_type;
	}
}







