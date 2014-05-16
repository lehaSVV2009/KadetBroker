package com.kadet.kadetBroker.entity;

import java.util.List;

public interface Model {

	public String getText ();
	public void setText (String text);
	public List<Customer> getAllCustomers ();
	public void addCustomer (Customer customer);
	
}
