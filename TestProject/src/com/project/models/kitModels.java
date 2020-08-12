package com.project.models;

public class kitModels {
	
	private int id;
	private String personName;
	private String email;
	private String contactNumber;
	private String status;
	private String orderDate;
	
	
	
	
	public kitModels(int id, String personName, String email, String contactNumber, String status, String orderDate) {
		super();
		this.id = id;
		this.personName = personName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.status = status;
		this.orderDate = orderDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
	

}
