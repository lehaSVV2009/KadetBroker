package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.entity.Customer;

/**
 * Date: 18.05.14
 * Time: 6:55
 *
 * @author SarokaA
 */
public class CreateCustomerController implements Controller {

    private Customer customer;

    public void setCustomer (Customer customer) {
        this.customer = customer;
    }
}
