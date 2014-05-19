package com.kadet.kadetBroker.dto;

import com.kadet.kadetBroker.entity.Customer;

/**
 * Date: 19.05.14
 * Time: 13:29
 *
 * @author SarokaA
 */
public class UpdateCustomerDTO implements DTO {

    private Customer oldCustomer;
    private Customer newCustomer;

    public UpdateCustomerDTO (Customer oldCustomer, Customer newCustomer) {
        this.oldCustomer = oldCustomer;
        this.newCustomer = newCustomer;
    }

    public Customer getOldCustomer () {
        return oldCustomer;
    }

    public Customer getNewCustomer () {
        return newCustomer;
    }
}
