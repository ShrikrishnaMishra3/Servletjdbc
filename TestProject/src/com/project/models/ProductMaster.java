
package com.project.models;

import org.json.JSONArray;
import org.json.JSONObject;

import com.project.dao.ProductMasterDao;

import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ProductMaster {
	private int id;
	private String ProductName;
	private String Cost;
	private String ProductDescription;

	public ProductMaster(int id, String ProductName, String Cost, String ProductDescription) {
		this.id = id;
		this.ProductName = ProductName;
		this.Cost = Cost;
		this.ProductDescription = ProductDescription;
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

	public static ArrayList<ProductMaster> getLastFive() {
		return (ArrayList<ProductMaster>) new ProductMasterDao().getLastFiveItems();
	}
	
	@Override
	public String toString() {
		return "Item{" + "id=" + id + ", ProductName=" + ProductName + ", Cost=" + Cost + ", ProductDescription='"
				+ ProductDescription + '}';
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof ProductMaster && this.id == ((ProductMaster) o).getId();
	}



	public JSONObject toJSON() {
		JSONObject itemJsonObject = new JSONObject();
		itemJsonObject.put("id", id);
		itemJsonObject.put("name", ProductName);
		itemJsonObject.put("price", Cost);
		itemJsonObject.put("url", ProductDescription);
		itemJsonObject.put("quantitySold", new ProductMasterDao().getQuantitySold(this));
		return itemJsonObject;
	}

	public boolean save() {
		return new ProductMasterDao().saveProductMaster(this);
	}


	public static Collection<ProductMaster> getAllItems() {
		return new ProductMasterDao().getAllItem();
	}

	public JSONObject updateIProductMaster(JSONObject req) {
//        Seller s = Seller.find(id);

		this.setProductName(req.getString("ProductName"));
		this.setCost(req.getString("Cost"));
		ProductMasterDao productMasterDao = new ProductMasterDao();
		this.save();
		return new JSONObject().put("status", Response.Status.OK.getStatusCode());
	}


	}

}
