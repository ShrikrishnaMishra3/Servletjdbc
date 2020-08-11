
package com.project.models;

import org.json.JSONArray;
import org.json.JSONObject;

import com.project.dao.KitDao;
import com.project.dao.ProductMasterDao;

import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Kit {
	private int id;
	private String PersonName;
	private String Email;
	private String ContactNumber;
	private String Status;
	private String OrderDate;


	public Kit(int id, String PersonName, String Email, String ContactNumber,String Status, String OrderDate) {
		this.id = id;
		this.PersonName = PersonName;
		this.Email = Email;
		this.ContactNumber = ContactNumber;
		this.Status = Status;
		this.OrderDate = OrderDate;

	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPersonName() {
		return PersonName;
	}



	public void setPersonName(String personName) {
		PersonName = personName;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getContactNumber() {
		return ContactNumber;
	}



	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public String getOrderDate() {
		return OrderDate;
	}



	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}



	public static ArrayList<Kit> getLastFive() {
		return (ArrayList<Kit>) new KitDao().getLastFiveItems();
	}

	@Override
	public String toString() {
		return "Item{" + "id=" + id + ", PersonName=" + PersonName + ", Email=" + Email + ", ContactNumber='"
				+ ContactNumber +", Status=" + Status + ", OrderDate='"
						+ OrderDate +  '}';
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Kit && this.id == ((ProductMaster) o).getId();
	}



	public JSONObject toJSON() {
		JSONObject itemJsonObject = new JSONObject();
		itemJsonObject.put("id", id);
		itemJsonObject.put("PersonName", PersonName);
		itemJsonObject.put("Email", Email);
		itemJsonObject.put("ContactNumber", ContactNumber);
		itemJsonObject.put("Status", Status);
		itemJsonObject.put("OrderDate", OrderDate);
		itemJsonObject.put("quantitySold", new KitDao().getQuantitySold(this));
		return itemJsonObject;
	}

	public boolean save() {
		return new KitDao().saveKit(this);
	}


	public static Collection<Kit> getAllItems() {
		return new KitDao().getAllItem();
	}

	public JSONObject updateKit(JSONObject req) {
		
		
		this.setPersonName(req.getString("PersonName"));
		this.setEmail(req.getString("Email"));
		this.setContactNumber(req.getString("ContactNumber"));
		this.setStatus(req.getString("Status"));
		this.setOrderDate(req.getString("OrderDate"));

		ProductMasterDao productMasterDao = new ProductMasterDao();
		this.save();
		return new JSONObject().put("status", Response.Status.OK.getStatusCode());
	}


	}

}
