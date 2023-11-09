package com.inditex.api.models;

import java.util.Currency;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ELECTRONIC_COMERCIAL")
public class PriceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private Long id;
	
	
	@Column(columnDefinition = "INT")
	private Integer brandId;
	
	
	@Column(columnDefinition = "VARCHAR")
	private String startDate;
	
	
	@Column(columnDefinition = "VARCHAR")
	private String endDate;
	
	
	@Column(columnDefinition = "INT")
	private Integer priceList;
	
	
	@Column(columnDefinition = "INT")
	private Integer productId;
	
	
	@Column(columnDefinition = "INT")
	@JsonIgnore
	private Integer priority;
	
	
	@Column(columnDefinition = "DECIMAL(10,2)")
	private Double price;
	
	
	@Column(columnDefinition = "VARCHAR(3)")
	@JsonIgnore
	private Currency curr;

	
	public Long getId() {
		return id;
	}
	
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getPriceList() {
		return priceList;
	}
	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Currency getCurr() {
		return curr;
	}
	public void setCurr(Currency curr) {
		this.curr = curr;
	}
	
}
