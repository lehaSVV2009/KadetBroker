package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.fwk.ModelChangeListener;
import com.kadet.kadetBroker.fwk.PropertyChangingType;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.CustomerInfoViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

import javax.swing.*;

public class CustomerInfoView extends JPanel implements View, ModelChangeListener, CurrentCustomerContainer {

    /*private CustomerInfoDTO customerInfoDTO;

	private Customer currentCustomer;
	  */

    private CustomerInfoViewModel viewModel;

	private JLabel customerIdLabel = new JLabel(Strings.CUSTOMER_ID_LABEL);
	private JTextField customerIdTextField = new JTextField();
	
	private JLabel customerNameLabel = new JLabel(Strings.CUSTOMER_NAME_LABEL);
	private JTextField customerNameTextField = new JTextField();
	
	private JLabel customerAddressLabel = new JLabel(Strings.CUSTOMER_ADDRESS_LABEL);
	private JTextField customerAddressTextField = new JTextField();
	
	public CustomerInfoView () {
		init();
	}
	
	private void init () {
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(customerIdLabel)
								.addComponent(customerNameLabel)
								.addComponent(customerAddressLabel)
						)
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(customerIdTextField)
								.addComponent(customerNameTextField)
								.addComponent(customerAddressTextField)
						)
		);
		
		layout.setVerticalGroup(
			layout.createSequentialGroup()
            	.addGroup(
            			layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				                .addComponent(customerIdLabel)
				                .addComponent(customerIdTextField))
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(customerNameLabel)
								.addComponent(customerNameTextField))
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(customerAddressLabel)
								.addComponent(customerAddressTextField))
        );
		
	}

    @Override
	public void refresh() {
    }

    @Override
    public void refresh (PropertyChangingType changingType, Object changedObject) {
//        this.currentCustomer = (Customer)changedObject;
    }

    /*private void setCustomerTextFields (Customer customer) {
        customerIdTextField.setText(customer.getId());
        customerNameTextField.setText(customer.getName());
        customerAddressTextField.setText(customer.getAddress());
    }

    private void clearCustomerTextFields () {
        customerIdTextField.setText("");
        customerNameTextField.setText("");
        customerAddressTextField.setText("");
    }

    @Override
    public void setModel (TO model) {
        this.customerInfoDTO = (CustomerInfoDTO) model;
        this.currentCustomer = customerInfoDTO.getCurrentCustomerTO();
    }

    @Override
    public TO getViewModel () {
        return customerInfoDTO;
    }
        */
	@Override
	public void handleModelChange(Object object) {
		
	}

    @Override
    public void setViewModel (ViewModel viewModel) {
        this.viewModel = (CustomerInfoViewModel) viewModel;
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

        customerIdTextField.setText(viewModel.getCurrentCustomerTO().getId());
        customerNameTextField.setText(viewModel.getCurrentCustomerTO().getName());
        customerAddressTextField.setText(viewModel.getCurrentCustomerTO().getAddress());
    }
}