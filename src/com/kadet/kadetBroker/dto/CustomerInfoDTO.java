package com.kadet.kadetBroker.dto;

import com.kadet.kadetBroker.entity.Customer;

/**
 * Date: 19.05.14
 * Time: 12:52
 *
 * @author SarokaA
 */
public class CustomerInfoDTO implements DTO {

    private Customer currentCustomer;

    public CustomerInfoDTO (Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public Customer getCurrentCustomer () {
        return currentCustomer;
    }
}
