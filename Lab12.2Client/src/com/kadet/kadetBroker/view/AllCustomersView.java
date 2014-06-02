package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.actions.AllCustomersButtonsAction;
import com.kadet.kadetBroker.actions.CustomerTableMouseAction;
import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.AllCustomersViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

import javax.swing.*;
import java.util.List;

public class AllCustomersView extends JPanel implements View, CurrentCustomerContainer {

    private AllCustomersViewModel viewModel;

    private JScrollPane tableScrollPane = new JScrollPane();
    private JTable customersTable = new JTable();

    private JButton addCustomerButton = new JButton(Strings.ADD_CUSTOMER_BUTTON);
    private JButton removeCustomerButton = new JButton(Strings.REMOVE_CUSTOMER_BUTTON);
    private JButton updateCustomerButton = new JButton(Strings.UPDATE_CUSTOMER_BUTTON);
    private JButton refreshCustomersButton = new JButton(Strings.REFRESH_CUSTOMERS_BUTTON);

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
        refreshCustomersButton.addActionListener(allCustomersButtonsAction);

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
                                        .addComponent(refreshCustomersButton)
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
                                        .addComponent(refreshCustomersButton)
                        )
        );

    }

    @Override
    public void refresh () {

        ViewManager.getInstance().unSubscribe(this, viewModel);

        AllCustomersViewModel allCustomersViewModel = Dispatcher.getInstance().getAllCustomersViewModel();
        List<CustomerTO> oldCustomerTOList = viewModel.getCustomersListTO();
        oldCustomerTOList.clear();
        for (CustomerTO newCustomerTO : allCustomersViewModel.getCustomersListTO()) {
            oldCustomerTOList.add(newCustomerTO);
        }
        customersTable.setModel(
                new CustomersTableModel(oldCustomerTOList));

        ViewManager.getInstance().subscribe(this, viewModel);

    }


    @Override
    public void setViewModel (ViewModel viewModel) {
        this.viewModel = (AllCustomersViewModel) viewModel;

        customersTable.setModel(
                new CustomersTableModel(this.viewModel.getCustomersListTO()));
    }

    @Override
    public ViewModel getViewModel () {
        return viewModel;
    }

    @Override
    public void refreshByCurrentCustomer (CustomerTO customerTO) {
        CustomerTO oldCustomerTO = viewModel.getCurrentCustomerTO();
        oldCustomerTO.setId(customerTO.getId());
        oldCustomerTO.setName(customerTO.getName());
        oldCustomerTO.setAddress(customerTO.getAddress());
    }
}
