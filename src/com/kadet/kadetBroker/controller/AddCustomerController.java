package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.dto.CustomerDTO;
import com.kadet.kadetBroker.dto.DTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.Dispatcher;

import java.util.Random;

/**
 * Date: 18.05.14
 * Time: 6:55
 *
 * @author SarokaA
 */
public class AddCustomerController implements Controller {

    private CustomerDTO customerDTO;

    private Customer customer;

    public void setCustomer (Customer customer) {
        this.customer = customer;
    }

    @Override
    public void setModel (DTO model) {
        this.customerDTO = (CustomerDTO)model;
        this.customer = customerDTO.getCustomer();
    }

    public void addCustomer () {

        // TODO: send to server customerDTO
        customerDTO.getCustomer().setId(String.valueOf(new Random().nextInt(10000)));
        Dispatcher.getInstance().addCustomer(customerDTO);

    }


    @Override
    public DTO getModel () {
        return customerDTO;
    }
}
