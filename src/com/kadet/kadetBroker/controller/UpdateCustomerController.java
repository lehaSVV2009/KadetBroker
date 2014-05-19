package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.dto.DTO;
import com.kadet.kadetBroker.dto.UpdateCustomerDTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.Dispatcher;

/**
 * Date: 19.05.14
 * Time: 13:43
 *
 * @author SarokaA
 */
public class UpdateCustomerController implements Controller {

    private UpdateCustomerDTO updateCustomerDTO;

    public void updateCustomer () {

        // TODO: send to the server
        updateCustomerDTO.getNewCustomer().setId(updateCustomerDTO.getOldCustomer().getId());
        Dispatcher.getInstance().updateCustomer(updateCustomerDTO);

    }

    @Override
    public void setModel (DTO model) {
        this.updateCustomerDTO = (UpdateCustomerDTO) model;
    }

    @Override
    public DTO getModel () {
        return updateCustomerDTO;
    }
}
