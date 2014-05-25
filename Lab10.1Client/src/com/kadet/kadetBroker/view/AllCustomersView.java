package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.actions.AllCustomersButtonsAction;
import com.kadet.kadetBroker.actions.CustomerTableMouseAction;
import com.kadet.kadetBroker.fwk.*;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.AllCustomersViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

import javax.swing.*;
import java.util.List;

public class AllCustomersView extends JPanel implements View, ModelChangeListener, CurrentCustomerContainer {

    private AllCustomersViewModel viewModel;

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
    /*    customers.clear();
        for (Customer customer : Dispatcher.getInstance().getAllCustomers()) {
            customers.add(customer);
        }
        customersTable.setViewModel(
                new CustomersTableModel(customers));
    */
    }



    @Override
    public void refresh (PropertyChangingType changingType, Object changedObject) {
    /*    switch (changingType) {
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
        */
    }
  /*
    @Override
    public void setModel (TO model) {
        this.allCustomersDTO = (AllCustomersDTO) model;
        this.currentCustomer = allCustomersDTO.getCurrentCustomerTO();
        this.customers = allCustomersDTO.getCustomers();
    }

    @Override
    public TO getViewModel () {
        return allCustomersDTO;
    }
   */
	@Override
	public void handleModelChange(Object object) {
		// TODO Auto-generated method stub
		
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
