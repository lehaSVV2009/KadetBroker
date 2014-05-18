package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.dialog.AddCustomerDialog;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.ControllerManager;
import com.kadet.kadetBroker.fwk.DialogFactory;
import com.kadet.kadetBroker.fwk.Dispatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 16.05.14
 * Time: 8:15
 *
 * @author SarokaA
 */
public class AllCustomersController implements Controller {

    private List<Customer> customers;
    private Customer currentCustomer;

    public AllCustomersController () {
    }

    public void setCustomers (List<Customer> customers) {
        this.customers = customers;
    }

    public void setCurrentCustomer (Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public List<Customer> getCustomers () {
        return customers;
    }

    public Customer getCurrentCustomer () {
        return currentCustomer;
    }

    public void showCreateCustomerDialog () {

        System.out.println("Show Create Customer Dialog");
        Customer newCustomer = Dispatcher.getInstance().getDefaultCustomer();
        AddCustomerDialog addCustomerDialog = (AddCustomerDialog)DialogFactory.createDialog(AddCustomerDialog.class.getName());
        addCustomerDialog.setCustomer(newCustomer);

        CreateCustomerController createCustomerController = (CreateCustomerController) ControllerManager.getInstance().newController(CreateCustomerController.class.getName());
        createCustomerController.setCustomer(newCustomer);

        addCustomerDialog.setVisible(true);
    }

}
