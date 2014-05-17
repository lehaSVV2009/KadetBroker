package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 16.05.14
 * Time: 8:15
 *
 * @author SarokaA
 */
public class AllCustomersController implements Controller {

    private List<Customer> customers = new ArrayList<Customer>();
    private Customer currentCustomer = null;

    public AllCustomersController (List<Customer> customers) {
        this.customers = customers;
    }

    public void showCustomersNumber () {
        System.out.println("Customers size" + customers.size());
    }

}
