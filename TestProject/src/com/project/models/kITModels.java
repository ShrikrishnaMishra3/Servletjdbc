package com.project.models;

public class kITModels {
	
	private int id;
	private String PersonName;
	private String Email;
	private String ContactNumber;
	public kITModels(int id2, String personName2, String email2, String contactNumber2, String status2, String orderDate2) {
		
	}
	public kITModels(String personName2, String email2, String contactNumber2, String status2, String orderDate2) {
		// TODO Auto-generated constructor stub
	}
	public kITModels(int id2) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "kITModels [id=" + id + ", PersonName=" + PersonName + ", Email=" + Email + ", ContactNumber="
				+ ContactNumber + ", Status=" + Status + ", OrderDate=" + OrderDate + "]";
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
	private String Status;
	private String OrderDate;

}
