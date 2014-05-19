package com.kadet.kadetBroker.dto;

import com.kadet.kadetBroker.entity.Customer;

/**
 * Date: 19.05.14
 * Time: 13:27
 *
 * @author SarokaA
 */
public class AddCustomerDTO implements DTO {

    private Customer customer;

    public AddCustomerDTO (Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer () {
        return customer;
    }
}
