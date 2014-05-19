package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.dialog.AddCustomerDialog;
import com.kadet.kadetBroker.dialog.UpdateCustomerDialog;
import com.kadet.kadetBroker.dto.CustomerDTO;
import com.kadet.kadetBroker.dto.AllCustomersDTO;
import com.kadet.kadetBroker.dto.DTO;
import com.kadet.kadetBroker.dto.UpdateCustomerDTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.*;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.LoggerPanel;

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
        CustomerDTO customerDTO = new CustomerDTO(newCustomer);
        AddCustomerDialog addCustomerDialog = (AddCustomerDialog) DialogFactory.createDialog(AddCustomerDialog.class.getName());
        addCustomerDialog.setModel(customerDTO);

        AddCustomerController addCustomerController = (AddCustomerController) ControllerManager.getInstance().newController(AddCustomerController.class.getName());
        addCustomerController.setModel(customerDTO);

        ViewManager.getInstance().setActiveView(addCustomerDialog);
        addCustomerDialog.setVisible(true);

    }

    public void showUpdateCustomerDialog () {

        if (currentCustomer.getId() == null) {
            log(Strings.CHOOSE_CUSTOMER);
        } else {
            System.out.println("Show Update Customer Dialog");
            Customer newCustomer = Dispatcher.getInstance().getDefaultCustomer();
            Customer oldCustomer = currentCustomer;
            UpdateCustomerDTO updateCustomerDTO = new UpdateCustomerDTO(oldCustomer, newCustomer);
            UpdateCustomerDialog updateCustomerDialog = (UpdateCustomerDialog) DialogFactory.createDialog(UpdateCustomerDialog.class.getName());
            updateCustomerDialog.setModel(updateCustomerDTO);

            UpdateCustomerController updateCustomerController = (UpdateCustomerController) ControllerManager.getInstance().newController(UpdateCustomerController.class.getName());
            updateCustomerController.setModel(updateCustomerDTO);
            updateCustomerDialog.refresh();

            ViewManager.getInstance().setActiveView(updateCustomerDialog);
            updateCustomerDialog.setVisible(true);
        }
    }

    public void removeCustomer () {

        System.out.println("Remove selected Customer");
        if (currentCustomer.getId() == null) {
            log(Strings.CHOOSE_CUSTOMER);
        } else {

            CustomerDTO customerDTO = new CustomerDTO(currentCustomer);
            // TODO: send to server remove customer

            Dispatcher.getInstance().removeCustomer(customerDTO);

        }

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


    private void log (String text) {
        LoggerPanel loggerPanel = ViewManager.getInstance().getActiveLoggerPanel();
        loggerPanel.addViewText(ViewManager.getInstance().getActiveView(), text);
        loggerPanel.refresh();
    }

}
