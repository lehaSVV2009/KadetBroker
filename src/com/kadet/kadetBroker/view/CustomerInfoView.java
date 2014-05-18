package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.util.Strings;

import javax.swing.*;

public class CustomerInfoView extends JPanel implements View {

	private Customer currentCustomer;
	
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

    public void setCurrentCustomer (Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    @Override
	public void refresh() {
        if (currentCustomer.getId() != null) {
            setCustomerTextFields(currentCustomer);
        } else {
            clearCustomerTextFields();
        }
	}

    @Override
    public void refresh (Object changedObject) {
        this.currentCustomer = (Customer)changedObject;
    }

    private void setCustomerTextFields (Customer customer) {
        customerIdTextField.setText(customer.getId());
        customerNameTextField.setText(customer.getName());
        customerAddressTextField.setText(customer.getAddress());
    }

    private void clearCustomerTextFields () {
        customerIdTextField.setText("");
        customerNameTextField.setText("");
        customerAddressTextField.setText("");
    }

}