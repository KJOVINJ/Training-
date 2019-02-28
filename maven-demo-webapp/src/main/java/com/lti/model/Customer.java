package com.lti.model;

public class Customer {

	int cust_id;
	public int getCust_id() {
		return cust_id;
	}
	
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	String cust_name;
	String cust_email;
}
