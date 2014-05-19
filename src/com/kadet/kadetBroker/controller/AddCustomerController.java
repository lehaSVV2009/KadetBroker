package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.dto.AddCustomerDTO;
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

    private AddCustomerDTO addCustomerDTO;

    private Customer customer;

    public void setCustomer (Customer customer) {
        this.customer = customer;
    }

    @Override
    public void setModel (DTO model) {
        this.addCustomerDTO = (AddCustomerDTO)model;
        this.customer = addCustomerDTO.getCustomer();
    }

    public void addCustomer () {

        // TODO: send to server addCustomerDTO
        addCustomerDTO.getCustomer().setId(String.valueOf(new Random().nextInt(10000)));
        Dispatcher.getInstance().addCustomer(addCustomerDTO);

    }


    @Override
    public DTO getModel () {
        return addCustomerDTO;
    }
}
