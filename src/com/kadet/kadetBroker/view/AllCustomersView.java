package com.kadet.kadetBroker.view;

import java.util.List;

import javax.swing.*;

import com.kadet.kadetBroker.actions.AllCustomersButtonsAction;
import com.kadet.kadetBroker.actions.CustomerTableMouseAction;
import com.kadet.kadetBroker.dto.AllCustomersDTO;
import com.kadet.kadetBroker.dto.DTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.fwk.PropertyChangingType;
import com.kadet.kadetBroker.util.Strings;

public class AllCustomersView extends JPanel implements View {

    private AllCustomersDTO allCustomersDTO;

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

        AllCustomersButtonsAction allCustomersButtonsAction
                = new AllCustomersButtonsAction();
        addCustomerButton.addActionListener(allCustomersButtonsAction);
        removeCustomerButton.addActionListener(allCustomersButtonsAction);
        updateCustomerButton.addActionListener(allCustomersButtonsAction);

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
    public void refresh (PropertyChangingType changingType, Object changedObject) {
        switch (changingType) {
            case REFRESH_CUSTOMER_LIST: {

                refresh();
                break;
            }
            case CURRENT_CUSTOMER_CHANGING : {

                Customer newCurrentCustomer = (Customer)changedObject;
                currentCustomer.setId(newCurrentCustomer.getId());
                currentCustomer.setName(newCurrentCustomer.getName());
                currentCustomer.setAddress(newCurrentCustomer.getAddress());
                break;
            }
        }
    }

    @Override
    public void setModel (DTO model) {
        this.allCustomersDTO = (AllCustomersDTO) model;
        this.currentCustomer = allCustomersDTO.getCurrentCustomer();
        this.customers = allCustomersDTO.getCustomers();
    }

    @Override
    public DTO getModel () {
        return allCustomersDTO;
    }
}
