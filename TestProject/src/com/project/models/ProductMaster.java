package com.project.models;

import com.project.dao.ProductMasterDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ProductMaster {
	@Override
	public String toString() {
		return "ProductMaster [id=" + id + ", ProductName=" + ProductName + ", Cost=" + Cost + ", ProductDescription="
				+ ProductDescription + "]";
	}

	private int id;
	private String ProductName;
	private String Cost;
	private String ProductDescription;

	public ProductMaster(String ProductName, String Cost, String ProductDescription) {
		this.id = id;
		this.ProductName = ProductName;
		this.Cost = Cost;
		this.ProductDescription = ProductDescription;
	}

	public ProductMaster(int id2) {
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getCost() {
		return Cost;
	}

	public void setCost(String cost) {
		Cost = cost;
	}

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}

	public void setId(int id) {
		this.id = id;
	
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	}

	


