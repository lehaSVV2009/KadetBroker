package com.kadet.kadetBroker.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.kadet.kadetBroker.actions.AllCustomersButtonAction;
import com.kadet.kadetBroker.actions.CustomerTableMouseAction;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.util.Strings;

public class AllCustomersView extends JPanel implements View {

    private Customer currentCustomer;
    private List<Customer> customers;

    private JScrollPane tableScrollPane = new JScrollPane();
    private JTable customersTable = new JTable();

    private JButton addCustomerButton = new JButton(Strings.ADD_CUSTOMER_BUTTON);
    private JButton removeCustomerButton = new JButton(Strings.REMOVE_CUSTOMER_BUTTON);
    private JButton updateCustomerButton = new JButton(Strings.UPDATE_CUSTOMER_BUTTON);

    public AllCustomersView () {
        init();
    }

    private void init () {

        customersTable.addMouseListener(new CustomerTableMouseAction());

        tableScrollPane = new JScrollPane(customersTable);

        AllCustomersButtonAction allCustomersButtonAction
                = new AllCustomersButtonAction();
        addCustomerButton.addActionListener(allCustomersButtonAction);
        removeCustomerButton.addActionListener(allCustomersButtonAction);
        updateCustomerButton.addActionListener(allCustomersButtonAction);

        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(tableScrollPane)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(addCustomerButton)
                                        .addComponent(updateCustomerButton)
                                        .addComponent(removeCustomerButton)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(tableScrollPane)
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addCustomerButton)
                                        .addComponent(removeCustomerButton)
                                        .addComponent(updateCustomerButton)
                        )
        );

    }


    public void setCustomers (List<Customer> customers) {
        this.customers = customers;
    }

    public void setCurrentCustomer (Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public Customer getCurrentCustomer () {
        return currentCustomer;
    }

    public List<Customer> getCustomers () {
        return customers;
    }

    @Override
    public void refresh () {

        customers.clear();
        for (Customer customer : Dispatcher.getInstance().getAllCustomers()) {
            customers.add(customer);
        }
        customersTable.setModel(
                new CustomersTableModel(customers));

    }

    @Override
    public void refresh (Object changedObject) {
        this.currentCustomer = (Customer)changedObject;
    }

}
