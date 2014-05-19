package com.kadet.kadetBroker.dto;

import com.kadet.kadetBroker.entity.Customer;

import java.util.List;

/**
 * Date: 19.05.14
 * Time: 12:30
 *
 * @author SarokaA
 */
public class AllCustomersDTO implements DTO {

    private List<Customer> customers;
    private Customer currentCustomer;

    public AllCustomersDTO (List<Customer> customers, Customer currentCustomer) {
        this.customers = customers;
        this.currentCustomer = currentCustomer;
    }

    public List<Customer> getCustomers () {
        return customers;
    }

    public Customer getCurrentCustomer () {
        return currentCustomer;
    }
}
