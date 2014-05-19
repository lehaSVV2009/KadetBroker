package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.dialog.AddCustomerDialog;
import com.kadet.kadetBroker.dialog.UpdateCustomerDialog;
import com.kadet.kadetBroker.dto.AddCustomerDTO;
import com.kadet.kadetBroker.dto.AllCustomersDTO;
import com.kadet.kadetBroker.dto.DTO;
import com.kadet.kadetBroker.dto.UpdateCustomerDTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.*;

import java.util.List;

/**
 * Date: 16.05.14
 * Time: 8:15
 *
 * @author SarokaA
 */
public class AllCustomersController implements Controller {

    private AllCustomersDTO allCustomersDTO;

    private List<Customer> customers;
    private Customer currentCustomer;

    public AllCustomersController () {
    }

    public void showCreateCustomerDialog () {

        System.out.println("Show Create Customer Dialog");
        Customer newCustomer = Dispatcher.getInstance().getDefaultCustomer();
        AddCustomerDTO addCustomerDTO = new AddCustomerDTO(newCustomer);
        AddCustomerDialog addCustomerDialog = (AddCustomerDialog)DialogFactory.createDialog(AddCustomerDialog.class.getName());
        addCustomerDialog.setModel(addCustomerDTO);

        AddCustomerController addCustomerController = (AddCustomerController) ControllerManager.getInstance().newController(AddCustomerController.class.getName());
        addCustomerController.setModel(addCustomerDTO);

        ViewManager.getInstance().setActiveView(addCustomerDialog);
        addCustomerDialog.setVisible(true);

    }

    public void showUpdateCustomerDialog () {

        System.out.println("Show Update Customer Dialog");
        Customer newCustomer = Dispatcher.getInstance().getDefaultCustomer();
        Customer oldCustomer = currentCustomer;
        UpdateCustomerDTO updateCustomerDTO = new UpdateCustomerDTO(oldCustomer, newCustomer);
        UpdateCustomerDialog updateCustomerDialog = (UpdateCustomerDialog)DialogFactory.createDialog(UpdateCustomerDialog.class.getName());
        updateCustomerDialog.setModel(updateCustomerDTO);

        UpdateCustomerController updateCustomerController = (UpdateCustomerController) ControllerManager.getInstance().newController(UpdateCustomerController.class.getName());
        updateCustomerController.setModel(updateCustomerDTO);
        updateCustomerDialog.refresh();

        ViewManager.getInstance().setActiveView(updateCustomerDialog);
        updateCustomerDialog.setVisible(true);

    }

    @Override
    public void setModel (DTO model) {
        this.allCustomersDTO = (AllCustomersDTO) model;
        this.customers = allCustomersDTO.getCustomers();
        this.currentCustomer = allCustomersDTO.getCurrentCustomer();
    }

    @Override
    public DTO getModel () {
        return allCustomersDTO;
    }

}
