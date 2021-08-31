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
    private Integer stockId;
	
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="transaction_date")
	private Date transactionDate;

	@Column(name="vendor")
	private String vendor;
	
	@Column(name="batch_code")
	private String batchCode;
	
	@Column(name="invoice_num")
	private String invoiceNum;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="transaction_type")
    @Enumerated(EnumType.STRING)
	private StockType transactionType;
	
	public Stock() {
		super();
	}
	
	public Stock(Integer productId, Date transactionDate, String vendor, 
			     String batchCode, String invoiceNum, int quantity, StockType transactionType) {
		this.productId = productId;
		this.transactionDate = transactionDate;
		this.vendor = vendor;
		this.batchCode = batchCode;
		this.invoiceNum = invoiceNum;
		this.quantity = quantity;
		this.transactionType = transactionType;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStock_id(Integer stockId) {
		this.stockId = stockId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProduct_id(Integer productId) {
		this.productId = productId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatch_code(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public StockType getTransactionType() {
		return transactionType;
	}

	public void setTransaction_type(StockType transactionType) {
		this.transactionType = transactionType;
	}
}







