package com.kadet.kadetBroker.entity;

import java.util.ArrayList;
import java.util.List;

public class InfoModel implements Model {

	private String text;
	
	private List<Customer> customers = new ArrayList<Customer>();
	
	public void addCustomer (Customer customer) {
		customers.add(customer);
	}
	
	public void removeCustomer(Customer customer) {
		customers.remove(customer);
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}
	
}
